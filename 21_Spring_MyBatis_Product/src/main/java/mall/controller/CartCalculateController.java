package mall.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import member.model.MemberBean;
import member.model.MemberDao;
import order.model.OrderDetailsBean;
import order.model.OrderDetailsDao;
import order.model.OrdersDao;

@Controller
public class CartCalculateController {

	private final String command = "/calculate.mall";
	private final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	OrdersDao odao;
	
	OrderDetailsDao oddao;
	
	//cartList.jsp���� �Ѿ��(��ٱ��� ��Ϻ��⿡�� ���� Ŭ��)
	@RequestMapping(command)
	public String doAction(HttpSession session) {
		
		//1. ���ǿ� ����Ǿ� �ִ� �α����� ����� ���̵� ������ ������ ����
		String mid = ((MemberBean)session.getAttribute("loginInfo")).getId();

		//orders ���̺� : OID MID ORDERDATE
		//2. ���̺� ������ ����(��������ȣ, ȸ����ȣ, ���ó�¥)
		int cnt = odao.insertOrder(mid);
		
		//3. ���� ���� �� �Ʒ� �ڵ� ����
		if(cnt!=0) {
			//4. ���� ū(���� �ֱ��� �ֹ���) �ֹ���ȣ(oders ���̺��� ��������ȣ) ��������
			int oid = odao.getMaxOid();
			
			//5. ��ٱ����� ������ �����ͼ� map�� ����(��ǰ��ȣ, ����)
			Map<Integer,Integer> mapLists = ((MyCartList)session.getAttribute("mycart")).getAllOrderLists();
			
			//6. Ű�� ��(��ǰ ��ȣ)�� �������� �޼���
			Set<Integer> keyList = mapLists.keySet();
			
			int cnt2=0;
			//orderdetails ���̺� : ODID OID PNUM QTY
			//7. orderdetails bean�� �ֹ���ȣ, ��ǰ��ȣ, ���� ������ ����
			for(int key : keyList) {
				OrderDetailsBean odb = new OrderDetailsBean();
				odb.setOid(oid);
				odb.setPnum(key);
				odb.setQty(mapLists.get(key));
				
				// 8. ������ Bean�� oderdetails ���̺� ����
				cnt2 = oddao.insertOrderDetails(odb);
			}//for
			
			if(cnt2 != -1) {
				System.out.println("��������");
			}else {
				System.out.println("��������");
			}
			
		}//doAction
		return gotoPage;
	}
}

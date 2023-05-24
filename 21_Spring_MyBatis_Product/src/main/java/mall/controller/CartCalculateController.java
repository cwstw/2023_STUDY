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
import product.model.ProductDao;

@Controller
public class CartCalculateController {

	private final String command = "/calculate.mall";
	private final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	OrdersDao odao;
	
	@Autowired
	OrderDetailsDao oddao;
	
	@Autowired
	ProductDao pdao;
	
	@Autowired
	MemberDao mdao;
	
	//cartList.jsp에서 넘어옴(장바구니 목록보기에서 결제 클릭)
	@RequestMapping(command)
	public String doAction(HttpSession session) {
		
		//1. 세션에 저장되어 있는 로그인한 사람의 아이디 정보를 변수에 저장
		String mid = ((MemberBean)session.getAttribute("loginInfo")).getId();

		//orders 테이블 : OID MID ORDERDATE
		//2. 테이블에 데이터 삽입(시퀀스번호, 회원번호, 오늘날짜)
		int cnt = odao.insertOrder(mid);
		
		//3. 삽입 성공 시 아래 코드 수행
		if(cnt!=0) {
			//4. 제일 큰(제일 최근의 주문한) 주문번호(oders 테이블의 시퀀스번호) 가져오기
			int oid = odao.getMaxOid();
			
			//5. 장바구니의 정보를 가져와서 map에 저장(상품번호, 수량)
			Map<Integer,Integer> mapLists = ((MyCartList)session.getAttribute("mycart")).getAllOrderLists();
			
			//6. 키의 값(상품 번호)만 가져오는 메서드
			Set<Integer> keyList = mapLists.keySet();
			
			int cnt2=-1;
			int cnt3=-1;
			//orderdetails 테이블 : ODID OID PNUM QTY
			//7. orderdetails bean에 주문번호, 상품번호, 수량 데이터 저장
			for(int key : keyList) {
				OrderDetailsBean odb = new OrderDetailsBean();
				odb.setOid(oid);
				odb.setPnum(key);
				odb.setQty(mapLists.get(key));
				
				// 8. 저장한 Bean을 oderdetails 테이블에 삽입
				cnt2 += oddao.insertOrderDetails(odb);
				
				//9. 상품 재고 수량 감소
				cnt3 = pdao.decreaseStock(odb);
			}//for
			
			if(cnt2 != -1) {
				System.out.println("결제성공");
			}else {
				System.out.println("결제실패");
			}
			
			//10. 100 포인트 적립
			int cnt4 = mdao.increasePoint(mid);
			
		}//doAction
		return gotoPage;
	}
}

package mall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import mall.cart.ShoppingList;
import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class CartListController {

	private final String command = "list.mall";
	private final String getPage = "cartList";
	
	@Autowired
	ProductDao pdao;
	
	//��ٱ��� �߰�(CartAddController) => ��ٱ��� ���
	@RequestMapping(command)
	public String doAction(
			HttpSession session,
			Model model) {
		
		//�������� ����� ��ٱ��� �ҷ��ͼ� ������ �ڷ����� ������ ��ü�� ����
		MyCartList myCart = (MyCartList)session.getAttribute("myCart");
		
		// ��ǰ��ȣ, �ֹ������� ���·� ����
		Map<Integer,Integer> mapLists = myCart.getAllOrderLists();
		
		//Ű�� ��(��ǰ ��ȣ)�� �������� �޼���
		Set<Integer> keyList = mapLists.keySet();
		System.out.println("keyList : "+keyList);
		
		//��ٱ��� ��� �������� ������ ����Ʈ ��ü ����
		List<ShoppingList> slist =  new ArrayList<ShoppingList>();
		
		int totalAmount = 0;
		
		//�ݺ��ؼ� Ű�� ���� �ش��ϴ� ��ǰ ������ �����ͼ� ����
		for(Integer pnum : keyList) {
			//�ֹ� ������ ���� ��ٱ��� ��ü ����
			ShoppingList shopping = new ShoppingList();
			
			//��ٱ��Ͽ��� �ҷ��� �ֹ���ȣ�� �Ű������� ��ǰ�� ������ ������ ����
			ProductBean pb =  pdao.getOneProduct(pnum);
			
			//�ҷ��� ������ ��ٱ��� ��ü�� ����
			shopping.setPnum(pb.getNum());
			shopping.setPname(pb.getName());
			shopping.setPrice(pb.getPrice());//����
			shopping.setQty(mapLists.get(pnum));//�ֹ�����
			shopping.setAmount(pb.getPrice()*mapLists.get(pnum));
			
			//�� ��ǰ�ݾ� �����ؼ� ���ϱ�
			totalAmount += pb.getPrice();
			
			//��ٱ��� ����� �ݺ��ؼ� ����Ʈ ��ü�� ����
			slist.add(shopping);
		}
		//�� �Ӽ����� ��ٱ��� ��ϰ� �� �ݾ� �ѱ��
		model.addAttribute("slist",slist);
		model.addAttribute("totalAmount",totalAmount);
		return getPage;
	}
	
}

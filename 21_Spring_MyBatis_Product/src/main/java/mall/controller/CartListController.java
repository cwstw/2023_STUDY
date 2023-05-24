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
	
	//장바구니 추가(CartAddController) => 장바구니 목록
	@RequestMapping(command)
	public String doAction(
			HttpSession session,
			Model model) {
		
		//세션으로 저장된 장바구니 불러와서 원래의 자료형과 동일한 객체에 저장
		MyCartList myCart = (MyCartList)session.getAttribute("myCart");
		
		// 상품번호, 주문수량의 형태로 저장
		Map<Integer,Integer> mapLists = myCart.getAllOrderLists();
		
		//키의 값(상품 번호)만 가져오는 메서드
		Set<Integer> keyList = mapLists.keySet();
		System.out.println("keyList : "+keyList);
		
		//장바구니 목록 여러개를 저장할 리스트 객체 생성
		List<ShoppingList> slist =  new ArrayList<ShoppingList>();
		
		int totalAmount = 0;
		
		//반복해서 키의 값에 해당하는 상품 정보를 가져와서 저장
		for(Integer pnum : keyList) {
			//주문 정보를 담을 장바구니 객체 생성
			ShoppingList shopping = new ShoppingList();
			
			//장바구니에서 불러온 주문번호를 매개변수로 상품의 정보를 물러와 저장
			ProductBean pb =  pdao.getOneProduct(pnum);
			
			//불러온 정보를 장바구니 객체에 저장
			shopping.setPnum(pb.getNum());
			shopping.setPname(pb.getName());
			shopping.setPrice(pb.getPrice());//가격
			shopping.setQty(mapLists.get(pnum));//주문수량
			shopping.setAmount(pb.getPrice()*mapLists.get(pnum));
			
			//총 상품금액 누적해서 구하기
			totalAmount += pb.getPrice();
			
			//장바구니 목록을 반복해서 리스트 객체에 저장
			slist.add(shopping);
		}
		//모델 속성으로 장바구니 목록과 총 금액 넘기기
		model.addAttribute("slist",slist);
		model.addAttribute("totalAmount",totalAmount);
		return getPage;
	}
	
}

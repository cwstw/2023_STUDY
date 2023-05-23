package mall.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mall.cart.MyCartList;

@Controller
public class CartAddController {

	private final String command = "/add.mall";
	private final String gotoPage = "redirect:/list.mall";//CartListController
	
	//상품 상세보기 =>주문 클릭
	@RequestMapping(command)
	public String doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("orderqty") int orderqty,
			HttpSession session
			) {
		if(session.getAttribute("loginInfo")==null) {//로그인 안되어 있음
			//아래 부분을 거친 뒤엔 destination이 insert.prd에서 detail.prd로 변경
			session.setAttribute("destination", "redirect:/detail.prd?num="+num+"&pageNumber="+pageNumber);
			return "redirect:/loginForm.mb";//로그인 안했으면 다시 로그인 요청
		}else {//로그인 되어 있음
			//세션설정된 장바구니 가져오기
			MyCartList myCart = (MyCartList)session.getAttribute("myCart");
			if(myCart==null) {
				//세션설정된 장바구니가 없으면
				//장바구니 객체 생성
				myCart = new MyCartList();
			}
			//장바구니 객체에 숫자와 수량 추가
			myCart.addOrder(num,orderqty);
			
			//장바구니 하나만 사용하도록 세션 설정
			session.setAttribute("myCart", myCart);
			return gotoPage;
		}
	}
}

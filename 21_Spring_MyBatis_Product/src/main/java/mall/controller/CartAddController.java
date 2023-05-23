package mall.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartAddController {

	private final String command = "/add.mall";
	private final String getPage = "redirect:/detail.prd";
	
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
			return getPage;
		}
	}
}

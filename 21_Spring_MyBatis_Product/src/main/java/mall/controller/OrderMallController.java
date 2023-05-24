package mall.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import member.model.MemberBean;
import order.model.OrdersBean;
import order.model.OrdersDao;

@Controller
public class OrderMallController {

	private final String command = "/order.mall";
	private final String getPage = "orderList";
	
	@Autowired
	OrdersDao odao;
	
	//start.jsp 나의 주문내역 클릭
	@RequestMapping(command)
	public String doAction(
			HttpSession session,
			Model model) {

		//로그인 시 orderList.jsp이동
		if(session.getAttribute("loginInfo")==null){
			//만약 로그인이 안되어 있으면
			session.setAttribute("destination", "redirect:/order.mall");
			return "redirect:/loginForm.mb";
		}else {
			//만약 로그인 되어있으면
			// 세션 속성 설정된 로그인 정보 가져오기
			MemberBean loginInfo = (MemberBean)session.getAttribute("loginInfo");
			String ordersId = loginInfo.getId();
			
			List<OrdersBean> lists = odao.getOrdersById(ordersId);
			
			model.addAttribute("lists",lists);
		}
		return getPage;
	}
	
	
	
}

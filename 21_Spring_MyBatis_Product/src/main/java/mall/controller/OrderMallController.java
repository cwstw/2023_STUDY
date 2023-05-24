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
	
	//start.jsp ���� �ֹ����� Ŭ��
	@RequestMapping(command)
	public String doAction(
			HttpSession session,
			Model model) {

		//�α��� �� orderList.jsp�̵�
		if(session.getAttribute("loginInfo")==null){
			//���� �α����� �ȵǾ� ������
			session.setAttribute("destination", "redirect:/order.mall");
			return "redirect:/loginForm.mb";
		}else {
			//���� �α��� �Ǿ�������
			// ���� �Ӽ� ������ �α��� ���� ��������
			MemberBean loginInfo = (MemberBean)session.getAttribute("loginInfo");
			String ordersId = loginInfo.getId();
			
			List<OrdersBean> lists = odao.getOrdersById(ordersId);
			
			model.addAttribute("lists",lists);
		}
		return getPage;
	}
	
	
	
}

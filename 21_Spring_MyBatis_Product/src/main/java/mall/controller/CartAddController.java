package mall.controller;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartAddController {

	private final String command = "/add.mall";
	private final String getPage = "redirect:/detail.prd";
	
	//��ǰ �󼼺��� =>�ֹ� Ŭ��
	@RequestMapping(command)
	public String doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("orderqty") int orderqty,
			HttpSession session
			) {
		if(session.getAttribute("loginInfo")==null) {//�α��� �ȵǾ� ����
			//�Ʒ� �κ��� ��ģ �ڿ� destination�� insert.prd���� detail.prd�� ����
			session.setAttribute("destination", "redirect:/detail.prd?num="+num+"&pageNumber="+pageNumber);
			return "redirect:/loginForm.mb";//�α��� �������� �ٽ� �α��� ��û
		}else {//�α��� �Ǿ� ����
			return getPage;
		}
	}
}

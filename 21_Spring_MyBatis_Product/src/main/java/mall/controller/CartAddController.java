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
			//���Ǽ����� ��ٱ��� ��������
			MyCartList myCart = (MyCartList)session.getAttribute("myCart");
			if(myCart==null) {
				//���Ǽ����� ��ٱ��ϰ� ������
				//��ٱ��� ��ü ����
				myCart = new MyCartList();
			}
			//��ٱ��� ��ü�� ���ڿ� ���� �߰�
			myCart.addOrder(num,orderqty);
			
			//��ٱ��� �ϳ��� ����ϵ��� ���� ����
			session.setAttribute("myCart", myCart);
			return gotoPage;
		}
	}
}

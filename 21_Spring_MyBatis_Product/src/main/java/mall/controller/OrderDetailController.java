package mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import order.model.OrdersDao;
import product.model.CompositeDao;
import product.model.ProductBean;

@Controller
public class OrderDetailController {
	
	private final String command = "/orderDetail.mall";
	private final String getPage = "orderDetailView";
	
	@Autowired
	CompositeDao cdao;
	
	//orderList.jsp���� �󼼺��� Ŭ��
	@RequestMapping(command)
	public String doAction(
			@RequestParam("oid") int oid,
			Model model
			) {
			//orderDetails�� product ���̺��� �������� �Բ� ��ȸ
			//composite.xml���� �۾�
			/* select * from orderdetails, product
			where orderdetails */
			
			List<ProductBean> lists = cdao.getOrderDetailByOid(oid);
			model.addAttribute("lists",lists);
			
			return getPage;
	}
}

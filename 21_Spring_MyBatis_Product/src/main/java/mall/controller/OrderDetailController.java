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
	
	//orderList.jsp에서 상세보기 클릭
	@RequestMapping(command)
	public String doAction(
			@RequestParam("oid") int oid,
			Model model
			) {
			//orderDetails와 product 테이블을 조인으로 함께 조회
			//composite.xml에서 작업
			/* select * from orderdetails, product
			where orderdetails */
			
			List<ProductBean> lists = cdao.getOrderDetailByOid(oid);
			model.addAttribute("lists",lists);
			
			return getPage;
	}
}

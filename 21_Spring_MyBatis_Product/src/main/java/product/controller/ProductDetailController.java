package product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class ProductDetailController {

	private final String command = "/detail.prd";
	private final String getPage = "productDetail";

	@Autowired
	ProductDao productDao;

	@RequestMapping(command)

	public ModelAndView detail(
			@RequestParam("num") int num, 
			@RequestParam("pageNumber") int pageNumber){


		ModelAndView mav = new ModelAndView();

		ProductBean productBean = productDao.getOneProduct(num);
		mav.addObject("productBean", productBean);
		mav.setViewName(getPage);

		return mav;
	}
}
package product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import product.model.ProductBean;
import product.model.ProductDao;
import utility.Paging;

@Controller
public class ProductListController {
	
	private final String command = "/list.prd";
	private String getPage = "productList";
	
	@Autowired
	ProductDao productDao;
	
	@RequestMapping(command)
	public ModelAndView doAction(
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword,
			Model model, HttpServletRequest request) {
		System.out.println("doaction");
		
		ModelAndView mav = new ModelAndView();
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		//map이 포함된 레코드 갯수 구하기
		int totalCount = productDao.getTotalCount(map);
		
		System.out.println("tc:"+totalCount);
		
		//url
		String url = request.getContextPath() + command;

		//페이징
		Paging pageInfo = new Paging(pageNumber, "5", totalCount, url, whatColumn, keyword, null);

		//List
		List<ProductBean> productLists = productDao.getProductList(pageInfo, map);

		mav.addObject("pageInfo", pageInfo);
		mav.addObject("productLists", productLists);
		mav.setViewName(getPage);//productList
		return mav;
	}

}
package product.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class ProductDeleteController {

	private final String command = "delete.prd";
	private final String gotoPage = "redirect:/list.prd";
	@Autowired
	ProductDao productDao;

	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = command)
	public String doAction(@RequestParam("num") int num,
			@RequestParam("pageNumber") String pageNumber,
			Model model) {
		
		ProductBean pBean = productDao.getOneProduct(num);
		
		int cnt = productDao.deleteProduct(num);  
		
		if(cnt != -1) {
			System.out.println("DB 삭제 성공");
			
			//ProductBean pBean = productDao.getOneProduct(num); // 여기 있던것을 위로 이동
			
			//resources 폴더 경로
			String deletePath = servletContext.getRealPath("/resources");
			System.out.println("deletePath:" + deletePath+"\\"+pBean.getImage());
			
			//이미지 파일 경로
			File prdImage = new File(deletePath+File.separator+pBean.getImage());
			
			boolean flag = prdImage.delete();
			
			if(flag==true) {
				System.out.println("이미지 삭제 성공");
			}else {
				System.out.println("이미지 삭제 실패");
			}
			
		}
		else {
			System.out.println("삭제 실패");
		}
		model.addAttribute("pageNumber", pageNumber);
		return gotoPage;

	}
}
package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class ProductUpdateController {
	
	private final String command = "update.prd";
	private final String getPage = "productUpdateForm";
	private final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	ProductDao pdao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public ModelAndView doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber
			) {
		
		ModelAndView mav = new ModelAndView();
		
		ProductBean pb = pdao.getOneProduct(num);
		
		mav.addObject("pb",pb);
		mav.addObject("pageNumber",pageNumber);
		mav.setViewName(getPage);
		
		return mav;
	}

	@RequestMapping(value = command, method = RequestMethod.POST)
	public String doAction(
			@ModelAttribute("pb") @Valid ProductBean pb,
			BindingResult result, Model model,
			@RequestParam("pageNumber") int pageNumber) {
		
		model.addAttribute("pageNumber", pageNumber);
		
		//������Ʈ â�� ��
		if(pb.getImage().equals("")) {
			pb.setImage(pb.getUpload2());
		}
		if(result.hasErrors()) {
			return getPage;
		}else {
			String filePath = servletContext.getRealPath("/resources");
			File deleteImage = new File(filePath +File.separator+pb.getUpload2()); //�����Ϸ��� �̹���
			File destination = new File(filePath + File.separator + pb.getUpload().getOriginalFilename()); //�����Ϸ���(���ε���) �̹���
			//������ �̹��� : pb.getUpload2();
			//������ �̹��� : pb.getUpload();
			
			int cnt = pdao.updateProduct(pb);
			
			if(cnt > -1) { // DB ���̺��� ���� ����
				boolean flag = deleteImage.delete();
				System.out.println("����: " +flag);
				
				MultipartFile multi = pb.getUpload();
				try {
					multi.transferTo(destination); // ���ε�
					
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return gotoPage;
				
			} else {
				return getPage;
			}
		}
		
	}
}

package member.controller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberBean;
import member.model.MemberDao;
import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class MemberDeleteController {

	private final String command = "delete.mb";
	private final String getPage = "redirect:/list.mb";
	
	@Autowired
	MemberDao mdao;
	
	@RequestMapping(value = command)
	public String doAction(@RequestParam("id") String id,
			@RequestParam("pageNumber") String pageNumber,
			Model model) {
		
		int cnt = mdao.deleteMember(id) ;  
		
		model.addAttribute("pageNumber", pageNumber);
		return getPage;

	}
}
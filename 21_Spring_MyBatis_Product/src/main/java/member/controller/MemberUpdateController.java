package member.controller;

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

import member.model.MemberBean;
import member.model.MemberDao;
import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class MemberUpdateController {

	private final String command = "update.mb";
	private final String getPage = "memberUpdateForm";
	private final String gotoPage = "redirect:/list.mb";
	
	@Autowired
	MemberDao mdao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public ModelAndView doAction(
			@RequestParam("id") String id,
			@RequestParam("pageNumber") int pageNumber
			) {
		
		ModelAndView mav = new ModelAndView();
		
		MemberBean mb = mdao.getOneMember(id);
		
		mav.addObject("mb",mb);
		mav.addObject("pageNumber",pageNumber);
		mav.setViewName(getPage);
		
		return mav;
	}

	@RequestMapping(value = command, method = RequestMethod.POST)
	public String doAction(
			@ModelAttribute("mb") @Valid MemberBean mb,
			BindingResult result, Model model,
			@RequestParam("pageNumber") int pageNumber) {
		
		model.addAttribute("pageNumber", pageNumber);
		
		if(result.hasErrors()) {
			return getPage;
		}else {
			int cnt = mdao.updateMember(mb);
			if(cnt > -1) {
				return gotoPage;
			} else {
				return getPage;
			}
		}
		
	}
	
}

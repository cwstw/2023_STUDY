package com.spring.com;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	//form=>fomr.jsp
	
	@RequestMapping(value="form", method=RequestMethod.GET)
	public String form() {
		return "form";
	}
	
	//submit 누르면 아래 코드 수행
	@RequestMapping(value="form", method=RequestMethod.POST)
	public String input1(@Valid MemberBean mb, BindingResult result) {
		//model.addAttribute("memberBean",mb);
		
		System.out.println("result.hasErrors() : "+result.hasErrors());
		String page="result";
		if(result.hasErrors()) {//참
			page="form";
		}
		return page; //오류 발생 시 form, 정상 수행 시 result로 이동
	}
}

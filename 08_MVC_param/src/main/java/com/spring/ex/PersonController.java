package com.spring.ex;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/person")
public class PersonController {

	//링크 뒤에 담아서 보냈을 때
	@RequestMapping(value="/input")
	public String result1(Model model,HttpServletRequest request) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("name : "+name);
		System.out.println("age : "+age);
		model.addAttribute("name");
		
		return "/result1";
	}
	
	//링크 뒤에 담아서 보냈을 때
	@RequestMapping(value="/input2")
	public String result2(Model model,@RequestParam("id") String id, @RequestParam("passwd") String passwd, @RequestParam("addr") String addr) {
		//String id = request.getParameter("id");
		System.out.println("id : "+id);
		System.out.println("passwd : "+passwd);
		System.out.println("addr : "+addr);
		PersonBean pb = new PersonBean();
		pb.setId(id);
		pb.setPasswd(passwd);
		pb.setAddr(addr);
		model.addAttribute("pb",pb);
		return "/result2";
	}
	
	@RequestMapping(value="/form")
	public String form() {
		return "/form";
	}
	
	@RequestMapping(value="/input3")
	public String input3(Model model,@RequestParam("id") String id, @RequestParam("passwd") String passwd, @RequestParam("addr") String addr) {
		PersonBean pb = new PersonBean();
		pb.setId(id);
		pb.setPasswd(passwd);
		pb.setAddr(addr);
		model.addAttribute("pb",pb);
		return "/result3";
	}
	
	@RequestMapping(value="/input4")
	public String input4(PersonBean per) {
//		아래의 코드를 파라미터 한줄을 통해 다 수행 (==command 객체)
//		String id = request.getParameter("id");
//		String passwd = request.getParameter("passwd");
//		String addr = request.getParameter("addr");
//		
//		PersonBean per = new PersonBean();
//		per.setId(id);
//		per.setPasswd(passwd);
//		per.setAddr(addr);
//		model.addAttribute("per",per);
		System.out.println(per.getId());
		System.out.println(per.getPasswd());
		System.out.println(per.getAddr());
		return "/result4";
	}
	
	@RequestMapping(value="/input5")
	public String input5(@ModelAttribute("abcd") PersonBean per) {
		return "/result5";
	}
	
}

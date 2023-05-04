package com.spring.ex;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {

	@RequestMapping("/form")
	public String form() {
		return "form";
	}

	@RequestMapping("/input1")
	public String input1(@RequestParam("name") String name, RedirectAttributes redirectAttr) {
		System.out.println("input1()");
		System.out.println(name);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("mname",name);
		
		redirectAttr.addFlashAttribute("redirectMap",map);
		
		//return "result";
		return "redirect:/input2"; //다시 컨트롤러 요청
	}
	//List(순서x 중복o
	//Set(순서o 중복x
	//Map(키와 값

	@RequestMapping("/input2")
	public Map input2(@RequestParam("name") String name,RedirectAttributes redirectAttr) {
		System.out.println("input2()");
		//좀 더 넓은 의미도 오브젝트 대신 ?사용
		Map<String,?> map = redirectAttr.getFlashAttributes();
		Object obj = map.get("mname");
		System.out.println("obj : "+obj);
		return map;
	}
	
}

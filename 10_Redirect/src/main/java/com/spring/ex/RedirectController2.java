package com.spring.ex;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController2 {
//form2=>form2.jsp
//input3=>input4
//input4=>result2.jsp
//form 입력항목 출력
	
	@RequestMapping("form2")
	public String form2() {
		return "form2";
	}
	
	@RequestMapping("input3")
	public String input3(HttpServletRequest request, RedirectAttributes ra) {
		String title = request.getParameter("title");
		String singer = request.getParameter("singer");
		String price = request.getParameter("price");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mtitle", title);
		map.put("msinger", singer);
		map.put("mprice", price);
		
		ra.addFlashAttribute("raMap",map);
		
		return "redirect:/input4";
	}
	
	@RequestMapping("input4")
	public Map<String, ?> input4(HttpServletRequest request, RedirectAttributes ra) {
		
		Map<String, ?> map = ra.getFlashAttributes();
		
		return map;
	}
	
}

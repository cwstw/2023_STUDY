package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class ExamController {

	@RequestMapping(value="/form")
	public String form() {
		return "board/form";
	}
	
	@RequestMapping(value="/list") //get,post 모두 처리
	public ModelAndView list() {
		//무엇을 가지고 어디로 갈 것인지 설정하는 클래스
		ModelAndView mav = new ModelAndView();
		mav.addObject("name","윤아");
		mav.addObject("age","30");
		mav.setViewName("member/list");
		return mav;
	}
	
}

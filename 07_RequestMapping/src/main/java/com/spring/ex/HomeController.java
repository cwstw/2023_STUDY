package com.spring.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/member/view") //get,post 모두 처리
	public String view() {
		return "member/memberview";
	}

	@RequestMapping(value="/member/input") //get,post 모두 처리
	public String input(Model model, HttpServletRequest request) {
		model.addAttribute("id","kim");
		request.setAttribute("pw", 1234);
		return "member/insertForm";
	}
	

	@RequestMapping(value="/member/list2") //get,post 모두 처리
	public ModelAndView list2() {
		//무엇을 가지고 어디로 갈 것인지 설정하는 클래스
		ModelAndView mav = new ModelAndView("member/list2");
		
		return mav;
	}
	
}

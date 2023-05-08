package com.spring.ex;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

	@RequestMapping(value="form", method=RequestMethod.GET)
	public String form(HttpServletRequest request) {
		System.out.println(request.getMethod());//메서드 출력
		return "bookForm";
	}

	@RequestMapping(value="form", method=RequestMethod.POST)
	public String form2(HttpServletRequest request) {
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String publisher = request.getParameter("publisher");
		String[] bookstore = request.getParameterValues("bookstore");
		String kind = request.getParameter("kind");
		return "result";
	}

	@RequestMapping(value="form", method=RequestMethod.POST)
	public String form3(@Valid BookBean bb,BindingResult result) {
		if(result.hasErrors()) {
			return "bookForm";
		}
		return "result2";
	}

	
	
	
}

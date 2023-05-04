package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("music")
public class MusicController {
	
	@RequestMapping("/form")
	public String form() {
		return "/form";
	}
	
	@RequestMapping("/input1")
	public String result1(HttpServletRequest request) {
		String title = request.getParameter("title");
		String singer = request.getParameter("singer");
		String price = request.getParameter("price");
		
		System.out.println("title : "+title);
		System.out.println("singer : "+singer);
		System.out.println("price : "+price);
		return "/result1";
	}

	@RequestMapping("/input2")
	public String result2(@RequestParam("title") String title,@RequestParam("singer") String singer,@RequestParam("price") String price) {
		System.out.println("title : "+title);
		System.out.println("singer : "+singer);
		System.out.println("price : "+price);
		return "/result2";
	}
	
	@RequestMapping("/input3")
	public String result3(MusicBean mb) {
//		String title = request.getParameter("title");
//		String singer = request.getParameter("singer");
//		String price = request.getParameter("price");
//		
//		MusicBean mb = new MusicBean();
//		mb.setTitle(title);
//		mb.setSinger(singer);
//		mb.getPrice(price);
//		reqeust.setAttribute("mb",mb);
		System.out.println("title : "+mb.getTitle());
		System.out.println("singer : "+mb.getSinger());
		System.out.println("price : "+mb.getPrice());
		return "/result3";
	}

	@RequestMapping("/input4")
	public String result4(@RequestParam("mb") MusicBean mb) {
		System.out.println("title : "+mb.getTitle());
		System.out.println("singer : "+mb.getSinger());
		System.out.println("price : "+mb.getPrice());
		return "/result4";
	}
	
}

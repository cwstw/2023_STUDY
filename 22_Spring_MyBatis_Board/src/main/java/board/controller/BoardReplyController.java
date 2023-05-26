package board.controller;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardReplyController {


	private final String command = "/reply.bd";
	private final String getPage = "replyInsertForm";
	private final String gotoPage = "redirect:/list.bd";
	
	@Autowired
	BoardDao bdao;
	
	//content에서 답글달기 클릭
	@RequestMapping(value=command,method=RequestMethod.GET)
	public ModelAndView doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber", pageNumber);
		mav.setViewName(getPage);
		
		return mav;
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(
			@ModelAttribute("bb") @Valid BoardBean bb,
			BindingResult result,
			@RequestParam("pageNumber") int pageNumber,
			HttpServletRequest request
			) {
		
			ModelAndView mav = new ModelAndView();
			mav.addObject("pageNumber",pageNumber);
			
			
			if(result.hasErrors()) {
				mav.setViewName(getPage);
			}else {
				bb.setIp(request.getRemoteAddr());
				int cnt = bdao.insertReply(bb);
					
				if(cnt != -1) {//삽입 성공
					mav.setViewName(gotoPage);
				}else {//실패
					mav.setViewName(getPage);
				}
			}
		return mav;
	}
	
}

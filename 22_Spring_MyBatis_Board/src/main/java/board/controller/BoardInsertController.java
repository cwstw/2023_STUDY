package board.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardInsertController {

	private final String command = "/insert.bd";
	private final String getPage = "boardInsertForm";
	private final String gotoPage = "redirect:/list.mv";
	
	@Autowired
	BoardDao bdao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(
			@ModelAttribute("pb") BoardBean bb,
			@RequestParam("pageNumber") int pageNumber,
			HttpServletRequest request
			) {
		
			ModelAndView mav = new ModelAndView();
			
			bb.setIp(request.getRemoteAddr());
			
			int cnt = -1;
			
			cnt = bdao.insertBoard(bb);
			
			if(cnt != -1) {//성공
				mav.setViewName(gotoPage);
			}else {//실패
				mav.setViewName(getPage);
			}
		return mav;
	}
	
}

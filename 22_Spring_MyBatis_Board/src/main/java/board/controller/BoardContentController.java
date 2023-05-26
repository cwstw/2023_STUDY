package board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardContentController {

	private final String command = "/content.bd";
	private final String getPage = "redirect:/content.bd";
	private final String gotoPage = "boardContentView";
	
	@Autowired
	BoardDao bdao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber
			) {
		
		ModelAndView mav = new ModelAndView();
		
		int cnt = bdao.updateReadcount(num);
		if(cnt != -1) {
			BoardBean bb = bdao.getBoardByNum(num);
			mav.addObject("bb",bb);
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(gotoPage);
		}else {
			mav.setViewName(getPage);
		}

		return mav;
	}
	
}

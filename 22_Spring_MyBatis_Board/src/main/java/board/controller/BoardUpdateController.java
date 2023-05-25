package board.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardUpdateController {

	private final String command = "/update.bd";
	private final String getPage = "boardUpdateForm";
	private final String gotoPage = "redirect:/content.bd";
	
	@Autowired
	BoardDao bdao;
	
	//상세보기에서 수정 클릭
	@RequestMapping(value=command,method=RequestMethod.GET)
	public ModelAndView doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber
			) {
		ModelAndView mav = new ModelAndView();
		BoardBean bb = bdao.getBoardByNum(num);
		//업데이트 폼으로 정보 넘겨줌
		mav.addObject("bb",bb);
		mav.addObject("pageNumber",pageNumber);
		mav.setViewName(getPage);
		return mav;
	}
	
	//updateform에서 넘어옴
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(
			@ModelAttribute("bb") BoardBean bb,
			@RequestParam("pageNumber") int pageNumber,
			HttpServletRequest request) {
		
			ModelAndView mav = new ModelAndView();
			
			bb.setIp(request.getRemoteAddr());
			
			int cnt = -1;
			
			cnt = bdao.updateBoard(bb);
			
			if(cnt != -1) {//성공
				mav.addObject("pageNumber",pageNumber);
				mav.addObject("num",bb.getNum());
				mav.setViewName(gotoPage);
			}else {//실패
				mav.addObject("pageNumber",pageNumber);
				mav.addObject("bb",bb);
				mav.setViewName(getPage);
			}
		return mav;
	}
	
}

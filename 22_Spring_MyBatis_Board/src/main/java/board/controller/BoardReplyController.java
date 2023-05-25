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
public class BoardReplyController {


	private final String command = "/reply.bd";
	private final String getPage = "boardReplyForm";
	private final String gotoPage = "redirect:/list.mv";
	
	@Autowired
	BoardDao bdao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(
			@ModelAttribute("bb") @Valid BoardBean bb,
			@RequestParam("pageNumber") int pageNumber,
			HttpServletRequest request
			) {
		
			ModelAndView mav = new ModelAndView();
			
			bb.setIp(request.getRemoteAddr());
			
			int cnt = -1, cnt2 = -1;
			
			cnt = bdao.UpdateReplyCount(bb);
			
			if(cnt != -1) {//업데이트 성공
				int restep = bb.getRestep()+1, relevel = bb.getRelevel();
				bb.setRestep(restep);
				bb.setRelevel(relevel);
				
				cnt2 = bdao.insertReply(bb);
				if(cnt != -1) {//삽입 성공
					mav.setViewName(gotoPage);
				}else {//실패
					restep = bb.getRestep()-1;
					relevel = bb.getRelevel();
					bb.setRestep(restep);
					bb.setRelevel(relevel);
					
					mav.addObject("bb",bb);
					mav.setViewName(getPage);
				}
			}else {//실패
				mav.addObject("bb",bb);
				mav.setViewName(getPage);
			}
		return mav;
	}
	
}

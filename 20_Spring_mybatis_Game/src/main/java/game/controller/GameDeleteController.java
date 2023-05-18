package game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import game.model.GameDao;

@Controller
public class GameDeleteController {

	private final String command = "delete.game";
	private final String getPage = "redirect:/list.game";
	
	@Autowired
	GameDao mdao;
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("num") int num
			) {
		ModelAndView mav = new ModelAndView();
			int cnt = -1;
			cnt = mdao.deleteGame(num);

			mav.addObject("pageNumber",pageNumber);
			mav.addObject("num",num);

			if(cnt != -1) {//성공
				mav.setViewName(getPage+"pageNumber="+pageNumber);
			}else {//실패
				mav.setViewName(getPage+"pageNumber="+pageNumber);
			}
		return mav;
	}
	
}

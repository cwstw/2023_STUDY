package game.controller;

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

import game.model.GameBean;
import game.model.GameDao;

@Controller
public class GameUpdateController {

	private final String command = "/update.game";
	private final String getPage = "gameUpdateForm";
	private final String gotoPage = "redirect:/list.game";
	
	@Autowired
	GameDao mdao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber,
			Model model) {
		GameBean gb = mdao.getOneGame(num);
		model.addAttribute("gb",gb);
		model.addAttribute("pageNumber",pageNumber);
		return getPage;
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(
			@RequestParam("pageNumber") int pageNumber,
			@ModelAttribute("movie") @Valid GameBean gb,
			BindingResult br) {
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(getPage);
		}else {
			int cnt = -1;
			cnt = mdao.updateGame(gb);
			if(cnt != -1) {//성공
				mav.setViewName(gotoPage+"?pageNumber="+pageNumber);
			}else {//실패
				mav.addObject("pageNumber",pageNumber);
				mav.addObject("num",gb.getNum());
				mav.setViewName("redirect:/"+command);
			}
		}
		return mav;
	}
	
}

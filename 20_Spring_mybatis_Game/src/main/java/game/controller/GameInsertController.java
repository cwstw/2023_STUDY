package game.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import game.model.GameBean;
import game.model.GameDao;
import utility.Paging;

@Controller
public class GameInsertController {

	private final String command ="insert.game";
	private final String getPage ="gameInsertForm";
	private final String gotoPage ="redirect:/list.game";
	
	@Autowired
	GameDao gdao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String doAction() {
		return getPage;
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(
			@ModelAttribute("gb") @Valid GameBean gb,
			BindingResult br) {
		
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {
			mav.setViewName(getPage);
		}else {
			int cnt = -1;
			cnt = gdao.insertGame(gb); 
			if(cnt != -1) {//성공
			mav.setViewName(gotoPage);
			}else {//실패
				mav.setViewName(getPage);
			}
		}
		return mav;
	}
	
}

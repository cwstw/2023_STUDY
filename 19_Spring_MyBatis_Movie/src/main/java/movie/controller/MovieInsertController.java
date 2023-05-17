package movie.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import movie.model.MovieBean;
import movie.model.MovieDao;

@Controller
public class MovieInsertController {
	
	private final String command = "insert.mv";
	private final String getPage = "movieInsertForm";
	private final String gotoPage = "redirect:/list.mv";
	
	@Autowired
	MovieDao mdao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String doAction() {
		return getPage;
	}

	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(
			@ModelAttribute("mv") @Valid MovieBean mb,
			BindingResult br) {
		
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {
			mav.setViewName(getPage);
		}else {
			int cnt = -1;
			cnt = mdao.insertMovie(mb); 
			if(cnt != -1) {//성공
			mav.setViewName(gotoPage);
			}else {//실패
				mav.setViewName(getPage);
			}
		}
		return mav;
	}
}
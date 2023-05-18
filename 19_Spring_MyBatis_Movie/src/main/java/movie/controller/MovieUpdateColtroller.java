package movie.controller;

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

import movie.model.MovieBean;
import movie.model.MovieDao;

@Controller
public class MovieUpdateColtroller {

	private final String command = "/update.mv";
	private final String getPage = "movieUpdateForm";
	private final String gotoPage = "redirect:/list.tv";
	
	@Autowired
	MovieDao mdao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber,
			Model model) {
		System.out.println("get��� update()");
		MovieBean mb = mdao.getOneMovie(num);
		model.addAttribute("mb",mb);
		model.addAttribute("pageNumber",pageNumber);
		return getPage;
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(
			@RequestParam("pageNumber") int pageNumber,
			@ModelAttribute("movie") @Valid MovieBean mb,
			BindingResult br) {
		System.out.println("post��� update()");
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(getPage);
		}else {
			int cnt = -1;
			cnt = mdao.updateMovie(mb);
			if(cnt != -1) {//����
				mav.setViewName(gotoPage+"?pageNumber="+pageNumber);
			}else {//����
				mav.addObject("pageNumber",pageNumber);
				mav.addObject("num",mb.getNum());
				mav.setViewName("redirect:/"+command);
			}
		}
		return mav;
	}
	
}

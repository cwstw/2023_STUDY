package movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import movie.model.MovieDao;

@Controller
public class MovieDeleteController {

	private final String command = "delete.mv";
	private final String getPage = "redirect:/list.mv";
	
	@Autowired
	MovieDao mdao;
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("num") int num
			) {
		ModelAndView mav = new ModelAndView();
			int cnt = -1;
			cnt = mdao.deleteMovie(num);

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

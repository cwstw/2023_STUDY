package movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import movie.model.MovieBean;
import movie.model.MovieDao;

@Controller
public class MovieDetailController {
	private final String command = "/detail.mv";
	private final String getPage = "movieDetailView";
	
	@Autowired
	MovieDao mdao;
	
	@RequestMapping(command)
	public String doAction(
			@ModelAttribute("num") int num,
			Model model) {
		
		MovieBean tb = mdao.getOneMovie(num);
		
		model.addAttribute("tb",tb);
		return getPage;
	}
}

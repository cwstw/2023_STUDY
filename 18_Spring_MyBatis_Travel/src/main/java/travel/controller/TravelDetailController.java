package travel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;
import utility.Paging;

@Controller
public class TravelDetailController {
	private final String command = "/detail.tv";
	private final String getPage = "travelDetailView";
	
	@Autowired
	TravelDao tdao;
	
	@RequestMapping(command)
	public String doAction(
			@ModelAttribute("num") int num, Model model) {
		
		TravelBean tb = tdao.getOneTravel(num);
		
		model.addAttribute("tb",tb);
		return getPage;
	}
}

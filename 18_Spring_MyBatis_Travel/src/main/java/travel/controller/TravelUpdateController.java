package travel.controller;

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

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelUpdateController {

	private final String command = "update.tv";
	private final String getPage = "travelUpdateForm";
	private final String gotoPage = "redirect:/list.tv";
	
	@Autowired
	TravelDao tdao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber,
			Model model) {
		System.out.println("get방식 update()");
		TravelBean tb = tdao.getOneTravel(num);
		model.addAttribute("tb",tb);
		model.addAttribute("pageNumber",pageNumber);
		return getPage;
	}

	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(
			@RequestParam("pageNumber") int pageNumber,
			@ModelAttribute("travel") @Valid TravelBean tb,
			BindingResult br) {
		System.out.println("post방식 update()");
		ModelAndView mav = new ModelAndView();
		if(br.hasErrors()) {
			mav.addObject("pageNumber",pageNumber);
			mav.setViewName(getPage);
		}else {
			int cnt = -1;
			cnt = tdao.updateTravel(tb);
			if(cnt != -1) {//성공
				mav.setViewName(gotoPage+"pageNumber="+pageNumber);
			}else {//실패
				mav.addObject("pageNumber",pageNumber);
				mav.addObject("num",tb.getNum());
				mav.setViewName("redirect:/"+command);
			}
		}
		return mav;
	}
	
}

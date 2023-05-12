package album.controller;

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

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumUpdateController {

	private final String command="update.ab";
	private final String getPage="albumUpdateForm";
	private final String gotoPage="redirect:/list.ab";
	
	@Autowired
	AlbumDao adao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String update(Model model, HttpServletRequest request) {
		//@RequestParam("num") String num으로도 가능
		int num = Integer.parseInt(request.getParameter("num"));
		
		AlbumBean ab = adao.getAlbumByNum(num);
		
		model.addAttribute("album",ab);
		return getPage;
	}

	@RequestMapping(value=command, method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("album") @Valid AlbumBean ab,BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
		}

		int cnt = adao.updateAlbum(ab);
		
		if(cnt != -1) { //수정 성공
			mav.setViewName(gotoPage);
		}else {//실패
			mav.setViewName(getPage);
		}
		return mav;
	}
	
}

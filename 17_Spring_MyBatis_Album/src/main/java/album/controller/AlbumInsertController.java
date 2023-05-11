package album.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumInsertController {

	private final String command="insert.ab";
	private String getPage="alubumInsertForm";
	private String gotoPage="redirect:/list.ab";
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String insert() {
		return getPage;
	}
	
	@Autowired
	AlbumDao albumDao;
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("album") @Valid AlbumBean ab,BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(getPage);
		}else {
			//에러가 없으면 값이 담긴 빈 객체를 dao로 넘기기
			int cnt = albumDao.InsertAlbum(ab);
			mav.setViewName(gotoPage);
		}
		return mav;
	}
	
}

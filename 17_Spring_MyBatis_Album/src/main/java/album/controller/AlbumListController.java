package album.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumListController {
	
	//requestmapping의 매개변수는 상수 표현식으로 설정
	private final String command = "/list.ab";
	private String getPage = "albumList";
	
	//AlbumDao에서 만든 객체 주입
	@Autowired
	AlbumDao albumDao;
	
	@RequestMapping(command)
	public ModelAndView doAction(Model model) {
		
		List<AlbumBean> albumLists = albumDao.getAlbumList();
		
		//model.addAttribute("albumlists",albumLists);
		//request.getParameter("albumlists",albumLists);
		ModelAndView mav = new ModelAndView();
		mav.addObject("albumlists",albumLists);
		mav.setViewName(getPage);
		
		return mav; //WEB-INF/album/albumList.jsp
	}
	
}

package album.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//2. whatColumn과 keyword가 넘어옴
	@RequestMapping(command)
	public ModelAndView doAction(
			@RequestParam(value="whatColumn", required = false) String whatColumn,
			@RequestParam(value="keyword", required = false) String keyword,
			Model model) {
		
		Map<String,String> map = new HashMap<String, String>();
		//%로 둘러싸서 포함된 것을 찾는다고 명시
		//null일 수도 있다
		map.put("whatColumn", "%"+whatColumn+"%"); 
		map.put("keyword", "%"+keyword+"%");
		
		List<AlbumBean> albumLists = albumDao.getAlbumList(map);
		
		//model.addAttribute("albumlists",albumLists);
		//request.getParameter("albumlists",albumLists);
		ModelAndView mav = new ModelAndView();
		mav.addObject("albumlists",albumLists);
		mav.setViewName(getPage);
		
		return mav; //WEB-INF/album/albumList.jsp
	}
	
}

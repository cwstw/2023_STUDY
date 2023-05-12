package album.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;
import utility.Paging;

@Controller
public class AlbumListController {
	
	
	
	//requestmapping의 매개변수는 상수 표현식으로 설정
	private final String command = "/list.ab";
	private String getPage = "albumList";
	
	//AlbumDao에서 만든 객체 주입
	@Autowired
	AlbumDao albumDao;
	
	//1. start에서 요청
	//2. whatColumn과 keyword가 넘어옴
	//3. 페이지 번호 클릭 했을 때( 클릭한 페이지 번호 넘김 )
	@RequestMapping(command)
	public ModelAndView doAction(
			@RequestParam(value="pageNumber", required = false) String pageNumber,
			@RequestParam(value="whatColumn", required = false) String whatColumn,
			@RequestParam(value="keyword", required = false) String keyword,
			Model model, HttpServletRequest request) {
		
		Map<String,String> map = new HashMap<String, String>();
		//%로 둘러싸서 포함된 것을 찾는다고 명시
		//null일 수도 있다
		map.put("whatColumn", "%"+whatColumn+"%"); 
		map.put("keyword", "%"+keyword+"%");
		
		int totalCount = albumDao.getTotalCount(map); 
		System.out.println(totalCount);
		
		String url = request.getContextPath()+command; //ex/list.ab
		System.out.println("url : "+url);
		
		Paging pageInfo = new Paging(pageNumber,"3",totalCount,url,whatColumn,keyword,null);
		System.out.println("offset : "+pageInfo.getOffset());
		System.out.println("limit : "+pageInfo.getLimit());
		
		List<AlbumBean> albumLists = albumDao.getAlbumList(map,pageInfo);
		
		//model.addAttribute("albumlists",albumLists);
		//request.getParameter("albumlists",albumLists);
		ModelAndView mav = new ModelAndView();
		mav.addObject("albumlists",albumLists);
		mav.addObject("pageIngo",pageInfo);//pageInfo 값 넘기기
		mav.setViewName(getPage);
		
		return mav; //WEB-INF/album/albumList.jsp
	}
	
}

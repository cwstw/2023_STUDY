package travel.controller;

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

import travel.model.TravelBean;
import travel.model.TravelDao;
import utility.Paging;

@Controller
public class TravelListController {
	
	private final String command = "/list.tv";
	private final String getPage = "travelList";
	
	@Autowired
	TravelDao tdao;
	
	@RequestMapping(command)
	public ModelAndView doAction(
			@RequestParam(value="pageNumber", required=false) String pageNumber,
			@RequestParam(value="whatColumn", required=false) String whatColumn,
			@RequestParam(value="keyword", required=false) String keyword,
			HttpServletRequest request) {
		
		Map<String,String> map = new HashMap<String,String>();
		
		//검색
		System.out.println("whatColumn : "+whatColumn);
		System.out.println("keyword : "+keyword);
		
		map.put("whatColumn", "%"+whatColumn+"%");
		map.put("keyword", "%"+keyword+"%");
		
		//페이징 : 전체 레코드 수 구하기
		int totalCount = tdao.getTotalCount(map);
		System.out.println("totalCount : "+totalCount);
		
		String url = request.getContextPath()+command;
		System.out.println("url : "+url);
		
		Paging pageInfo = new Paging(pageNumber,"3",totalCount,url,whatColumn,keyword,null);
		
		List<TravelBean> lists = tdao.getAllTravel(map, pageInfo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("lists", lists);
		mav.addObject("pageInfo", pageInfo);
		
		mav.setViewName(getPage);
		
		return mav;
	}
	
}

package game.controller;

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

import game.model.GameBean;
import game.model.GameDao;
import utility.Paging;

@Controller
public class GameListController {
	
	private final String command ="list.game";
	private final String getPage ="gameList";
	
	@Autowired
	GameDao gdao;
	
	@RequestMapping(command)
	public ModelAndView doAction(
			@RequestParam(value="pageNumber", required=false) String pageNumber,
			@RequestParam(value="searchCol", required=false) String searchCol,
			@RequestParam(value="searchWord", required=false) String searchWord,
			Model model, HttpServletRequest request) {
		
		System.out.println("list doAction()");
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchCol",searchCol); 
		map.put("searchWord",searchWord);
		
		int totalCount = gdao.getTotalCount(map);
		String url = request.getContextPath()+"/"+command;
		
		Paging pageInfo = new Paging(pageNumber,"5",totalCount,url,searchCol,searchWord,null);
		
		List<GameBean> glist = gdao.getAllGame(map,pageInfo);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("glist",glist);
		mav.addObject("pageInfo",pageInfo);
		mav.setViewName(getPage);
		
		return mav;
	}
}

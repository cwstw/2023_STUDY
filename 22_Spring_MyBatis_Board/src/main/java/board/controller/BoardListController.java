package board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;
import utility.Paging;

@Controller
public class BoardListController {

	private final String command = "/list.bd";
	private final String getPage = "boardList";
	
	@Autowired
	BoardDao bdao;
	
	@RequestMapping(value=command)
	public ModelAndView doAction(
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword,
			Model model, HttpServletRequest request) {
			
		ModelAndView mav = new ModelAndView();
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		//map이 포함된 레코드 갯수 구하기
		int totalCount = bdao.getTotalCount(map);
		
		System.out.println("tc:"+totalCount);
		
		//url
		String url = request.getContextPath() + command;

		//페이징
		Paging pageInfo = new Paging(pageNumber, "5", totalCount, url, whatColumn, keyword, null);

		//List
		List<BoardBean> boardLists = bdao.getBoardList(pageInfo, map);

		mav.addObject("pageInfo", pageInfo);
		mav.addObject("boardLists", boardLists);
		mav.setViewName(getPage);//boardList
		return mav;
	}
}

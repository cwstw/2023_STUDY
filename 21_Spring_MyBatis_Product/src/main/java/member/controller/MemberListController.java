package member.controller;

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

import member.model.MemberBean;
import member.model.MemberDao;
import utility.Paging;

@Controller
public class MemberListController {

	private final String command = "/list.mb";
	private String getPage = "memberList";
	
	@Autowired
	MemberDao mdao;
	
	@RequestMapping(command)
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
		int totalCount = mdao.getTotalCount(map);
		
		System.out.println("tc:"+totalCount);
		
		//url
		String url = request.getContextPath() + command;

		//페이징
		Paging pageInfo = new Paging(pageNumber, "5", totalCount, url, whatColumn, keyword, null);

		//List
		List<MemberBean> memberLists = mdao.getMemberList(pageInfo, map);

		mav.addObject("pageInfo", pageInfo);
		mav.addObject("memberLists", memberLists);
		mav.setViewName(getPage);//productList
		return mav;
	}
	
}

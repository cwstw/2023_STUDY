package board.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardDeleteController {

	private final String command = "/delete.bd";
	private final String getPage = "passwdCheckForm";
	private final String gotoPage = "redirect:/list.bd";
	
	@Autowired
	BoardDao bdao;
	
	//�󼼺��⿡�� ���� Ŭ��=>��й�ȣ üũ ������ �̵�
	@RequestMapping(value=command,method=RequestMethod.GET)
	public ModelAndView doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber
			) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("num",num);
		mav.addObject("pageNumber",pageNumber);
		mav.setViewName(getPage);
		return mav;
	}
	
	//boardcheckcontroller���� �Ѿ��(��й�ȣ ��ġ)
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber,
			Model model
			) {
		
			ModelAndView mav = new ModelAndView();
			
			int cnt = -1;
			
			cnt = bdao.deleteBoard(num);
			
			if(cnt != -1) {//����
				mav.addObject("pageNumber",pageNumber);
				mav.addObject("num",num);
				mav.setViewName(gotoPage);
			}else {//����
				mav.addObject("pageNumber",pageNumber);
				mav.addObject("num",num);
				mav.setViewName(getPage);
			}
		return mav;
	}
	
}

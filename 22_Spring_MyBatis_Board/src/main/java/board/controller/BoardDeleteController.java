package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(
			@ModelAttribute("bb") BoardBean bb,
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber,
			HttpServletResponse response, HttpServletRequest request
			) {
		
			ModelAndView mav = new ModelAndView();
			
			System.out.println("bb.getPasswd() : "+bb.getPasswd());
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			
			int cnt = -1;
			String dbpw = bdao.getBoardByNum(num).getPasswd();
				
			if(!bb.getPasswd().equals(dbpw)) {//�Է� ����� db����� ��ġ �� �ϸ�
					try {
						out = response.getWriter();
						
						out.println("<script language='javascript'>");
						out.println("alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.')");
						out.println("history.go(-1)");
						out.println("</script>");
						
						out.flush();
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}else {//��� ��ġ
					
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
					
				}
		return mav;
	}
	
}

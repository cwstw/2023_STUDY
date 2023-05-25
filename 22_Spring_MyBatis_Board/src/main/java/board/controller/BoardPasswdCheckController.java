package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardPasswdCheckController {
	
	private final String command = "/check.bd";
	private final String getPage = "passwdCheckForm";
	private final String gotoPage = "redirect:/delete.bd";
	
	@Autowired
	BoardDao bdao;

	//체크 폼에서 넘어옴
	@RequestMapping(value=command)
	public ModelAndView doAction(
			@ModelAttribute("check") BoardBean check,
			@RequestParam("pageNumber") String pageNumber,
			HttpServletResponse response
			) {
		ModelAndView mav = new ModelAndView();
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		
		if(check.getPasswd()==null) {
			try {
				out = response.getWriter();
				
				out.println("<script language='javascript'>");
				out.println("alert('비밀번호를 입력해주세요.')");
				out.println("</script>");
				
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mav.setViewName(getPage);
		}
		
		BoardBean bb = bdao.checkByPasswd(check);
		
		if(bb==null) {
			try {
				out = response.getWriter();
				
				out.println("<script language='javascript'>");
				out.println("alert('비밀번호가 일치하지 않습니다.')");
				out.println("</script>");
				
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mav.setViewName(getPage);
		}
		
		mav.addObject("pageNumber",pageNumber);
		mav.addObject("num",check.getNum());
		mav.setViewName(gotoPage);
		
		return mav;
	}
}

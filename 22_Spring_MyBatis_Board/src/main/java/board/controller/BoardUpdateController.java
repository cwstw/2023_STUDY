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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardUpdateController {

	private final String command = "/update.bd";
	private final String getPage = "boardUpdateForm";
	private final String gotoPage = "redirect:/content.bd";
	
	@Autowired
	BoardDao bdao;
	
	//상세보기에서 수정 클릭
	@RequestMapping(value=command,method=RequestMethod.GET)
	public ModelAndView doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber
			) {
		ModelAndView mav = new ModelAndView();
		BoardBean bb = bdao.getBoardByNum(num);
		//업데이트 폼으로 정보 넘겨줌
		mav.addObject("bb",bb);
		mav.addObject("pageNumber",pageNumber);
		mav.setViewName(getPage);
		return mav;
	}
	
	//updateform에서 넘어옴
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(
			@RequestParam("num") int num,
			@ModelAttribute("bb") @Valid BoardBean bb,
			BindingResult result,HttpServletResponse response,
			@RequestParam("pageNumber") int pageNumber,
			HttpServletRequest request) {
		
			ModelAndView mav = new ModelAndView();
			System.out.println("비번:"+bb.getPasswd());
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			
			bb.setIp(request.getRemoteAddr());
			
			int cnt = -1;
			if(result.hasErrors()) {//에러 = 공백
				
				try {
					out = response.getWriter();
					
					out.println("<script language='javascript'>");
					out.println("alert('비밀번호를 입력해주세요.')");
					out.println("history.go(-1)");
					out.println("</script>");
					
					out.flush();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {//에러 없음
				
					String dbpw = bdao.getBoardByNum(num).getPasswd();
				
					if(!bb.getPasswd().equals(dbpw)) {//입력 비번이 db비번과 일치 안 하면
						try {
							out = response.getWriter();
							
							out.println("<script language='javascript'>");
							out.println("alert('비밀번호가 일치하지 않습니다.')");
							out.println("history.go(-1)");
							out.println("</script>");
							
							out.flush();
							out.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else {//일치하면
						
						mav.addObject("pageNumber",pageNumber);
						mav.addObject("num",num);
						mav.setViewName(gotoPage);
					}
				}//에러 없음 else
				return mav;
		}
	}

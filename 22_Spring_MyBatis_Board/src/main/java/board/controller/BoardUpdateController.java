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
	
	//�󼼺��⿡�� ���� Ŭ��
	@RequestMapping(value=command,method=RequestMethod.GET)
	public ModelAndView doAction(
			@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber
			) {
		ModelAndView mav = new ModelAndView();
		BoardBean bb = bdao.getBoardByNum(num);
		//������Ʈ ������ ���� �Ѱ���
		mav.addObject("bb",bb);
		mav.addObject("pageNumber",pageNumber);
		mav.setViewName(getPage);
		return mav;
	}
	
	//updateform���� �Ѿ��
	@RequestMapping(value=command,method=RequestMethod.POST)
	public ModelAndView doAction(
			@RequestParam("num") int num,
			@ModelAttribute("bb") @Valid BoardBean bb,
			BindingResult result,HttpServletResponse response,
			@RequestParam("pageNumber") int pageNumber,
			HttpServletRequest request) {
		
			ModelAndView mav = new ModelAndView();
			System.out.println("���:"+bb.getPasswd());
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			
			bb.setIp(request.getRemoteAddr());
			
			int cnt = -1;
			if(result.hasErrors()) {//���� = ����
				
				try {
					out = response.getWriter();
					
					out.println("<script language='javascript'>");
					out.println("alert('��й�ȣ�� �Է����ּ���.')");
					out.println("history.go(-1)");
					out.println("</script>");
					
					out.flush();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {//���� ����
				
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
					}else {//��ġ�ϸ�
						
						mav.addObject("pageNumber",pageNumber);
						mav.addObject("num",num);
						mav.setViewName(gotoPage);
					}
				}//���� ���� else
				return mav;
		}
	}

package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberLoginController {
	
	private final String command = "/loginForm.mb";
	private final String getPage = "memberLoginForm";
	
	@Autowired
	MemberDao mdao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String doAction() {
		return getPage;
	}

	@RequestMapping(value=command,method=RequestMethod.POST)
	public String doAction(
			@RequestParam("id") String id,
			@RequestParam("password") String password,
			HttpServletResponse response,
			HttpSession session
			) {
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out;
		
		MemberBean mb = mdao.getOneMember(id);
		
		if(mb==null) {
			//System.out.println("존재하지 않는 아이디");
			try {
				out = response.getWriter();
				
				out.println("<script language='javascript'>");
				out.println("alert('아이디가 존재하지 않습니다.')");
				out.println("</script>");
				
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return getPage;
		}else if(!mb.getPassword().equals(password)){
			//System.out.println("비밀번호가 일치하지 않습니다");
			try {
				out = response.getWriter();
				
				out.println("<script language='javascript'>");
				out.println("alert('비밀번호가 일치하지 않습니다')");
				out.println("</script>");
				
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return getPage;
		}//elseif
		
		//세션 설정
		session.setAttribute("loginInfo", mb);
		
		
		return (String)session.getAttribute("destination");
	}
	
}

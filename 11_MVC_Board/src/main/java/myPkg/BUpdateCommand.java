package myPkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.BoardBean;
import Board.BoardDao;

public class BUpdateCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int num = Integer.parseInt(request.getParameter("num"));
		String pageNum = request.getParameter("pageNum");
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String passwd = request.getParameter("passwd");
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());
		String content = request.getParameter("content");
		
		BoardBean bb = new BoardBean(num,writer,email,subject,passwd,reg_date,content);
		
		BoardDao bdao = BoardDao.getInstance();
		int cnt = bdao.updateArticle(bb);
		System.out.println("cnt : " + cnt);
		PrintWriter out = null;
		response.setCharacterEncoding("text/html; charset=UTF-8");
		if(cnt!=1) {
			try {
				out = response.getWriter();
				out.append("<script>alert('비밀번호가 일치하지 않습니다.');history.go(-1);</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.flush();
			request.setAttribute("match", "false");
		}else {
			request.setAttribute("match", "true");
		}
		
		ServletContext sc = request.getServletContext();
		sc.setAttribute("pageNum", pageNum);
		sc.setAttribute("cnt", cnt);
	}

}
package myPkg;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.BoardBean;
import Board.BoardDao;

public class BWriteCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//int num = Integer.parseInt(request.getParameter("num"));
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String passwd = request.getParameter("passwd");
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());
		//int readcount = Integer.parseInt(request.getParameter("readcount"));
		//int ref = Integer.parseInt(request.getParameter("ref"));
		//int re_step = Integer.parseInt(request.getParameter("re_step"));
		//int re_level = Integer.parseInt(request.getParameter("re_level"));
		String content = request.getParameter("content");
		//String ip = request.getParameter("ip");
		
		BoardBean bb = new BoardBean(0, writer, email, subject, passwd, reg_date, 0, 0, 0, 0, content, "");
		
		BoardDao bdao = BoardDao.getInstance();
		
		bdao.insertArticle(bb);
	}
	
}

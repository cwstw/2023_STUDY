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
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String passwd = request.getParameter("passwd");
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());
		String content = request.getParameter("content");
		
		
		BoardBean bb = new BoardBean(0, writer, email, subject, passwd, reg_date, 0, 0, 0, 0, content, "");
		
		BoardDao bdao = BoardDao.getInstance();
		
		bdao.insertArticle(bb);
	}
	
}

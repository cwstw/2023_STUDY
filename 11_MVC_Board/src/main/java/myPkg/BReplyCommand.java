package myPkg;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.BoardBean;
import Board.BoardDao;

public class BReplyCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String writer = request.getParameter("writer");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String passwd = request.getParameter("passwd");
		Timestamp reg_date = new Timestamp(System.currentTimeMillis());
		String content = request.getParameter("content");
		int ref = Integer.parseInt(request.getParameter("ref"));
		int re_step = Integer.parseInt(request.getParameter("re_step"));
		int re_level = Integer.parseInt(request.getParameter("re_level"));
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		BoardBean bb = new BoardBean(0, writer, email, subject, passwd, reg_date, 0, ref, re_step, re_level, content, "");
		
		BoardDao bdao = BoardDao.getInstance();
		bdao.replyArticle(bb);
		
		
	}

}

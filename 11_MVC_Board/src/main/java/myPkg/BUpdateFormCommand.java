package myPkg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.BoardBean;
import Board.BoardDao;

public class BUpdateFormCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao bdao = BoardDao.getInstance();
		String num = request.getParameter("num");
		String pageNum = request.getParameter("pageNum");
		
		BoardBean article = bdao.getContentByNum(num);
		
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("article", article);
	}

}

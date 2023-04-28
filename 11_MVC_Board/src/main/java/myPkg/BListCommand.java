package myPkg;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.BoardBean;
import Board.BoardDao;

public class BListCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pageNum = request.getParameter("pageNum");

		if(pageNum == null) {
			pageNum = "1";
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		int pageSize = 10;
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage-1) * pageSize +1;
		int endRow = currentPage * pageSize;

		ArrayList<BoardBean> list = new ArrayList<BoardBean>();
		BoardDao bdao = BoardDao.getInstance();
		int count = bdao.getArticleCount();

		int number = count - (currentPage-1) * pageSize;
		list = bdao.getArticles(startRow, endRow);

		int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
		int pageBlock = 3;

		int startPage = ((currentPage -1 ) / pageBlock*pageBlock) +1 ;
		int endPage = startPage + pageBlock-1;

		if(pageCount < endPage) {
			endPage = pageCount;
		}

		System.out.println();

		request.setAttribute("list", list);
		request.setAttribute("count", count);
		request.setAttribute("number", number);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage",endPage );
		request.setAttribute("pageCount", pageCount);

	}

}
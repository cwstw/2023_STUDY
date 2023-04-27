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
		int pageSize = 5;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		
		String pageNum = request.getParameter("pageNum");//내가 선택한 페이지 번호
		System.out.println("pageNum : "+pageNum);
		if(pageNum==null){
			pageNum="1";//pageNum에 아무런 값이 없으면 1부터 시작
		}
		
		//선택한 페이지 번호 숫자로 변경
		int currentPage = Integer.parseInt(pageNum);
		//currentPage가 1일 경우 1
		int startRow = (currentPage-1)*pageSize+1;
		//currentPage가 1일 경우 5
		int endRow = currentPage * pageSize;
		
		BoardDao bdao = BoardDao.getInstance();
		
		ArrayList<BoardBean> lists = null;
		int count = bdao.getArticleCount();
		if(count > 0) {
			//startRow와 endRow를 넘겨 5개만 가져오기
			lists = bdao.getArticles(startRow,endRow);
		}
	}

}

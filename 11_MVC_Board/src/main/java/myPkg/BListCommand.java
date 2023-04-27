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
		
		String pageNum = request.getParameter("pageNum");//���� ������ ������ ��ȣ
		System.out.println("pageNum : "+pageNum);
		if(pageNum==null){
			pageNum="1";//pageNum�� �ƹ��� ���� ������ 1���� ����
		}
		
		//������ ������ ��ȣ ���ڷ� ����
		int currentPage = Integer.parseInt(pageNum);
		//currentPage�� 1�� ��� 1
		int startRow = (currentPage-1)*pageSize+1;
		//currentPage�� 1�� ��� 5
		int endRow = currentPage * pageSize;
		
		BoardDao bdao = BoardDao.getInstance();
		
		ArrayList<BoardBean> lists = null;
		int count = bdao.getArticleCount();
		if(count > 0) {
			//startRow�� endRow�� �Ѱ� 5���� ��������
			lists = bdao.getArticles(startRow,endRow);
		}
	}

}

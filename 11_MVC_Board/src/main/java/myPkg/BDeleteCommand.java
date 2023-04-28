package myPkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.BoardDao;

public class BDeleteCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao bdao = BoardDao.getInstance();
		String num = request.getParameter("num");
		String passwd = request.getParameter("passwd");
		String pageNum = request.getParameter("pageNum");
		
		int cnt = bdao.deleteArticle(num, passwd);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		if(cnt != 1) {
			try {
				out = response.getWriter();
				out.println("<script>alert('비번일치 안함');history.go(-1)</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
			out.flush();//alert을 브라우저에 출력request.setAttribute("match", "false");
			request.setAttribute("match", "false");
		}else { // 삭제 성공했으면
			
			int pageSize = 5;
			int count = bdao.getArticleCount();
			int pageCount = count/pageSize + (count%pageSize==0? 0 : 1);
			System.out.println("pageCount : " + pageCount);
			System.out.println("count : " + count);
			
			int pageN = Integer.parseInt(pageNum);
			
			System.out.println("pageN : " + pageN);
			if(pageCount < pageN){ // 3 < 4 (4-1)    3 < 2
				pageNum = String.valueOf(pageN-1);
			}else {
				
			}
			
			request.setAttribute("match", "true");
			request.setAttribute("pageNum", pageNum);
		}
	}

}
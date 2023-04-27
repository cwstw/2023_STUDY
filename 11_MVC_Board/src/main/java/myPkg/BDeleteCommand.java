package myPkg;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Board.BoardDao;

public class BDeleteCommand implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String num = request.getParameter("num");
		String passwd = request.getParameter("passwd");
		int pageNum = Integer.parseInt(request.getParameter("pageNum"));
		
		BoardDao bdao = BoardDao.getInstance(); 
		
		
		int cnt = bdao.deleteArticle(num, passwd);
		
		if(cnt == 1){
			int pageSize = 5;
			int count = bdao.getArticleCount(); //16=>15, 3페이지
			int pageCount = count / pageSize + (count%pageSize==0? 0 : 1);
			//만약 현재 페이지번호가 전체 페이지 번호보다 작거나 같으면
			//기존페이지로 이동, 아니면 기본페이지-1로 이동
				try {
					if( pageNum <= pageCount ){
					response.sendRedirect("select.jsp?pageNum="+pageNum);
					} else{
						response.sendRedirect("select.jsp?pageNum="+(pageNum-1));			
					}//if
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}else {
			/*
			 * <script type="text/javascript"> alert("비밀번호가 일치하지 않습니다."); <%--
			 * location.href="<%=url%>"; --%> history.go(-1); </script>
			 */
		}//if
	}

}

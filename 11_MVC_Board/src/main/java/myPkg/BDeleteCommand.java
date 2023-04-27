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
			int count = bdao.getArticleCount(); //16=>15, 3������
			int pageCount = count / pageSize + (count%pageSize==0? 0 : 1);
			//���� ���� ��������ȣ�� ��ü ������ ��ȣ���� �۰ų� ������
			//������������ �̵�, �ƴϸ� �⺻������-1�� �̵�
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
			 * <script type="text/javascript"> alert("��й�ȣ�� ��ġ���� �ʽ��ϴ�."); <%--
			 * location.href="<%=url%>"; --%> history.go(-1); </script>
			 */
		}//if
	}

}

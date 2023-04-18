<%@page import="ARTSHOP.BOARD.BOARDDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- BD_DELETEPROC.jsp -->
<%
	request.setCharacterEncoding("UTF-8");
	String num = request.getParameter("num");
	String passwd = request.getParameter("passwd");
	int pageNum = Integer.parseInt(request.getParameter("pageNum"));
	
	BOARDDAO bdao = BOARDDAO.getInstance(); 
%>
<jsp:useBean id="bb" class="ARTSHOP.BOARD.BOARDDTO"/>
<jsp:setProperty property="*" name="bb"/>
<%
	int cnt = bdao.deleteArticle(num, passwd);
	
	if(cnt == 1){
		int pageSize = 5;
		int count = bdao.getArticleCount(); //16=>15, 3페이지
		int pageCount = count / pageSize + (count%pageSize==0? 0 : 1);
		//만약 현재 페이지번호가 전체 페이지 번호보다 작거나 같으면
		//기존페이지로 이동, 아니면 기본페이지-1로 이동
		if( pageNum <= pageCount ){
			response.sendRedirect("select.jsp?pageNum="+pageNum);
		} else{
			response.sendRedirect("select.jsp?pageNum="+(pageNum-1));			
		}
	}else {
%>
		<script type="text/javascript">
			alert("비밀번호가 일치하지 않습니다.");
			<%-- location.href="<%=url%>"; --%>
			history.go(-1);	
		</script>
<%
	}
%>
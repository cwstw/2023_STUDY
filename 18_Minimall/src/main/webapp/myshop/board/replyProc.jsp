<%@page import="java.sql.Timestamp"%>
<%@page import="Board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
replyForm.jsp(5가지입력) => replyProc.jsp<br>

<%
	request.setCharacterEncoding("UTF-8");

	BoardDao bdao = BoardDao.getInstance(); 
	
	int pageNum = Integer.parseInt(request.getParameter("pageNum")); 
%>
<jsp:useBean id="bb" class="Board.BoardBean"/>
<jsp:setProperty property="*" name="bb"/>
<%
	bb.setReg_date(new Timestamp(System.currentTimeMillis()));
	bb.setIp(request.getRemoteAddr());
	
	int cnt = bdao.replyArticle(bb); //5+2+3 
 
	String msg = "작성 실패";
	String url = "replyForm.jsp?ref="+bb.getRef()+"&re_step="+bb.getRe_step()+"&re_level="+bb.getRe_level();
	
	if(cnt == 1){
		int pageSize = 5;
		int count = bdao.getArticleCount(); //16=>15, 3페이지
		int pageCount = count / pageSize + (count%pageSize==0? 0 : 1);
		//만약 현재 페이지번호가 전체 페이지 번호보다 작거나 같으면
		//기존페이지로 이동, 아니면 기본페이지-1로 이동
		if( pageNum <= pageCount ){
			msg = "작성 성공";
			url = "select.jsp?pageNum="+pageNum;
		} else{
			msg = "작성 성공";
			url ="select.jsp?pageNum="+(pageNum-1);			
		}
	}
%>

<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
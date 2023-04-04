<%@page import="Board.BoardDao"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="Board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
writeForm.jsp 요청 => writeProc.jsp<br>

<%
	request.setCharacterEncoding("UTF-8");
	BoardDao bdao = BoardDao.getInstance(); 
%>
<jsp:useBean id="bb" class="Board.BoardBean"/>
<jsp:setProperty property="*" name="bb"/>
<%
	bb.setReg_date(new Timestamp(System.currentTimeMillis()));
	bb.setIp(request.getRemoteAddr());
	
	int cnt = bdao.insertArticle(bb);
 
	String msg = "작성 실패";
	String url = "writeForm.jsp";
	
	if(cnt == 1){
		msg = "작성 성공";
		url = "select.jsp";
	}
%>

<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
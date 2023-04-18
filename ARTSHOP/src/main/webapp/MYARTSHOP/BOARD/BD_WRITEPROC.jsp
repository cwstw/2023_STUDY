<%@page import="ARTSHOP.BOARD.BOARDDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
writeForm.jsp 요청 => writeProc.jsp<br>

<%
	request.setCharacterEncoding("UTF-8");
	BOARDDAO bdao = BOARDDAO.getInstance(); 
%>
<jsp:useBean id="bb" class="ARTSHOP.BOARD.BOARDDTO"/>
<jsp:setProperty property="*" name="bb"/>
<%
	bb.setReg_date(new Timestamp(System.currentTimeMillis()));
	bb.setIp(request.getRemoteAddr());
	
	int cnt = bdao.insertArticle(bb);
 
	String msg = "작성 실패";
	String url = "BD_WRITEFORM.jsp";
	
	if(cnt == 1){
		msg = "작성 성공";
		url = "BOARDLIST.jsp";
	}
%>

<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
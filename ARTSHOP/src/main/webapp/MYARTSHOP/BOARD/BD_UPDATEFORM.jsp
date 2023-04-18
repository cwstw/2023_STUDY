<%@page import="ARTSHOP.BOARD.BOARDDTO"%>
<%@page import="ARTSHOP.BOARD.BOARDDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- BD_UPDATEFORM.jsp -->
<jsp:include page="../../ARTSHOP_MAIN_TOP.jsp"/>
<style>
	body{
		text-align: center;
	}
	table{
		margin:auto;
		/* width:700px; */
	
	}
	th{
	}
</style>
<%
	BOARDDAO bdao = BOARDDAO.getInstance();
	String num = request.getParameter("num");
	String pageNum = request.getParameter("pageNum");
	
	BOARDDTO article = bdao.getContentByNum(num); 
%>


<h3>글수정</h3>
content.jsp(num)=>updateForm.jsp

<form method="post" name="updateform" action="updateProc.jsp?<%=num %>&pageNum=<%=pageNum%>" onSubmit="return writeSave()">
<input type="hidden" name="num" value="<%=num%>">
<table width="600px">
	<tr>
		<th>이 름</th>
		<td><input type="text" name="writer" value="<%=article.getWriter()%>"></td>
	</tr>
	<tr>
		<th>제 목</th>
		<td><input type="text" name="subject" value="<%=article.getSubject()%>"></td>
	</tr>
	<tr>
		<th>Email</th>
		<td><input type="text" name="email" value="<%=article.getEmail()%>"></td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><textarea name="content" rows="20" cols="95"><%=article.getContent()%></textarea></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="passwd"></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" id="sub" value="글수정">
			<input type="reset" value="다시작성">
			<input type="button" value="목록보기" onClick="location.href='select.jsp'">
		</th>
	</tr>
</table>
</form>
<jsp:include page="../../ARTSHOP_MAIN_BOTTOM.jsp"/>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- BD_REPLYFORM.jsp -->
<jsp:include page="../../ARTSHOP_MAIN_TOP.jsp"/>
<%
	String ref = request.getParameter("ref");
	String re_step = request.getParameter("re_step");
	String re_level = request.getParameter("re_level");
	String pageNum = request.getParameter("pageNum");
	
	System.out.println(ref+", "+re_step+", "+re_level);
%>

<link rel="stylesheet" type="text/css" href="./style.css">
<style>
	body{
		text-align: center;
	}
	table{
		margin:auto;
		/* width:700px; */
	
	}
	input{
		width: 200px;
	}
</style>

<h3 class="m-3">답글쓰기</h3>

<form method="post" name="replyform" action="replyProc.jsp" onSubmit="return writeSave()">
<input type="hidden" name="ref" value="<%=ref %>">
<input type="hidden" name="re_step" value="<%=re_step %>">
<input type="hidden" name="re_level" value="<%=re_level %>">
<input type="hidden" name="pageNum" value="<%=pageNum %>">
<table width="600px">
	<tr>
		<th colspan="2" align="right">
			<a href="select.jsp">글목록</a>
		</th>
	</tr>
	<tr>
		<th>이 름</th>
		<td><input type="text" name="writer"></td>
	</tr>
	<tr>
		<th>제 목</th>
		<td><input type="text" name="subject" value="[답글]"></td>
	</tr>
	<tr>
		<th>Email</th>
		<td><input type="text" name="email"></td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><textarea name="content" rows="20" cols="95"></textarea></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="passwd"></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" id="sub" value="답글쓰기">
			<input type="reset" value="다시작성">
			<input type="button" value="목록보기" onClick="location.href='select.jsp'">
		</th>
	</tr>
</table>
</form>
<jsp:include page="../../ARTSHOP_MAIN_BOTTOM.jsp"/>


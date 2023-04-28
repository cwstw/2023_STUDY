<%@page import="Board.BoardBean"%>
<%@page import="Board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="color.jsp" %>
<link rel="stylesheet" type="text/css" href="./style.css">
<style>
	body{
		text-align: center;
		background: <%=bodyback_c %>
	}
	table{
		margin:auto;
		width:700px;
	
	}
	th{
		background: <%=value_c%>
	}
</style>
<script src="js/jquery.js"></script>
<script src="script.js"></script>
<!-- ==============style/script============== -->

<h3>글수정</h3>
content.jsp(num)=>updateForm.jsp

<form method="post" name="updateform" action="update.bd?${article.num }&pageNum=${pageNum}" onSubmit="return writeSave()">
<input type="hidden" name="num" value="${article.num}">
<table>
	<tr>
		<th>이 름</th>
		<td><input type="text" name="writer" value="${article.writer }"></td>
	</tr>
	<tr>
		<th>제 목</th>
		<td><input type="text" name="subject" value="${article.subject }"></td>
	</tr>
	<tr>
		<th>Email</th>
		<td><input type="text" name="email" value="${article.email }"></td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><textarea name="content" rows="20" cols="95">${article.content}</textarea></td>
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



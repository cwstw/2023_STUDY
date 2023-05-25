<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../color.jsp" %>
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
	input{
		width: 200px;
	}
</style>
<!-- replyInsertForm.jsp -->
<h3>답글쓰기</h3>
<form method="post" action="reply.bd">
<input type="hidden" name="ref" value="${bb.ref }">
<input type="hidden" name="re_step" value="${bb.restep }">
<input type="hidden" name="re_level" value="${bb.relevel }">
<input type="hidden" name="pageNum" value="${pageNumber }">
<table>
	<tr>
		<th colspan="2" align="right">
			<a href="list.bd">글목록</a>
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
			<input type="button" value="목록보기" onClick="location.href='list.bd'">
		</th>
	</tr>
</table>
</form>
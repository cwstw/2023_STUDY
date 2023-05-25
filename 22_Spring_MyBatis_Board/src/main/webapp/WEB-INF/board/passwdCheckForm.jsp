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
		width:500px;
		height:120px;
		text-align: center;
	}
	th{
		background: <%=value_c%>
	}
</style>
<!-- pwCheckForm.jsp -->
<center>
	<h3>글삭제</h3>
	<form method="post" action="check.bd">
	<input type="hidden" name="pageNumber" value="${pageNumber}">
	<input type="hidden" name="num" value="${bb.num}">
	<table>
	<tr>
		<th>비밀번호를 입력하세요.</th>
	</tr>
	<tr>
		<td>비밀번호 : <input type="password" name="passwd" style="width:70px"></td>
	</tr>
	
	<tr>
		<th>
			<input type="submit" id="sub" value="글삭제">
			<input type="button" value="목록보기" onClick="location.href='list.bd?pageNumber=${pageNumber}'">
		</th>
	</tr>
	</table>
	</form>
</center>
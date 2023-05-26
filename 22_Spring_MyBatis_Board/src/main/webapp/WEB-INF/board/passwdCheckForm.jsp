<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp" %>
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
	.err{
		font-weight: bold;
		color : red;
	}
</style>
<!-- pwCheckForm.jsp -->
<center>
	<h3>글삭제</h3>
	<form:form method="post" action="delete.bd">
	<input type="hidden" name="pageNumber" value="${pageNumber}">
	<input type="hidden" name="num" value="${num}">
	<table>
	<tr>
		<th>비밀번호를 입력하세요.</th>
	</tr>
	<tr>
		<td>비밀번호 : <input type="text" name="passwd" style="width:70px">
		</td>
	</tr>
	
	<tr>
		<th>
			<input type="submit" id="sub" value="글삭제">
			<input type="button" value="목록보기" onClick="location.href='list.bd?pageNumber=${pageNumber}'">
		</th>
	</tr>
	</table>
	</form:form>
</center>
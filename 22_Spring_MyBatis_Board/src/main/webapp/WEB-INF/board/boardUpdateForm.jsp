<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp" %>
<%@include file="../color.jsp" %>
<link rel="stylesheet" type="text/css" href="../style.css">
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
	.err{
		font-weight: bold;
		color : red;
	}
</style>
<!-- boardUpdateForm.jsp -->
<h3>글수정</h3>

<form:form commandName="bb" method="post" action="update.bd">
		<input type="hidden" name="pageNumber" value="${pageNumber}">
		<input type="hidden" name="num" value="${bb.num}">
<table>
	<tr>
		<th colspan="2" align="right">
			<a href="list.bd">글목록</a>
		</th>
	</tr>
	<tr>
		<th>이 름</th>
		<td><input type="text" name="writer" value="${bb.writer }">
		<form:errors cssClass="err" path="writer"/></td>
	</tr>
	<tr>
		<th>제 목</th>
		<td><input type="text" name="subject" value="${bb.subject }">
		<form:errors cssClass="err" path="subject"/></td>
	</tr>
	<tr>
		<th>Email</th>
		<td><input type="text" name="email" value="${bb.email }">
		<form:errors cssClass="err" path="email"/></td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><textarea name="content" rows="20" cols="95">
		${bb.content }
		</textarea><form:errors cssClass="err" path="content"/></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="text" name="passwd" value="${bb.passwd}">
		<form:errors cssClass="err" path="passwd"/></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" value="수정하기">
			<input type="reset" value="다시작성">
			<input type="button" value="목록보기" onClick="location.href='list.bd'">
		</th>
	</tr>
</table>
</form:form>
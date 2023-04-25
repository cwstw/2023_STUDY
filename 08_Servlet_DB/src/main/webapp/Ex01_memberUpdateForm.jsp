<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
Ex01_memberUpdateForm.jsp<br>
<h3 align="center">회원가입</h3>
<form action="update.mb" method="post">
	<input type="hidden" name="no" value="${mb.no}">
	<table border="1" align="center" width="80%">
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${mb.name}"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="password" value="${mb.password}"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="수정하기">
			</td>
		</tr>
	</table>
</form>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- gameUpdateForm.jsp -->
<form action="update.game" method="post">
<table border="1">
	<tr>
		<td>제목</td>
		<td><input type="text" name="title" value="${gb.title} }"></td>
	</tr>
	<tr>
		<td>장르</td>
		<td><input type="text" name="genre" value="${gb.genre}"></td>
	</tr>
	<tr>
		<td>난이도</td>
		<td><input type="text" name="difficulty" value="${gb.difficulty}"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="수정하기"></td>
	</tr>
</table>
</form>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- gameInsertForm.jsp -->
<form action="insert.game" method="post">
<table border="1">
	<tr>
		<td>제목</td>
		<td><input type="text" name="title"></td>
	</tr>
	<tr>
		<td>장르</td>
		<td><input type="text" name="genre"></td>
	</tr>
	<tr>
		<td>난이도</td>
		<td><input type="text" name="difficulty"></td>
	</tr>
		<tr>
		<td colspan="2"><input type="submit" value="등록하기"></td>
	</tr>
</table>
</form>
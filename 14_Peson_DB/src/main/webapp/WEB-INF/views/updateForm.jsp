<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
updateForm.jsp<br>

<form action="update" method="post">
	<input type="text" name="num" value="${pd.num }">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="${pd.id }"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${pd.name }"></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="age" value="${pd.age }"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="입력"></td>
		</tr>
	</table>
</form>
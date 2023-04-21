<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
memberForm.jsp<br>
<form action="Member" method="post">
<table border="1"> <!-- result.jsp 입력항목 모두 출력 -->
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="age">
		</tr>
		<tr>
			<td>성별</td>
			<td><input type="radio" name="gender" value="남자">남자 <input
				type="radio" name="gender" value="여자">여자</td>
		</tr>
		<tr>
			<td>취미</td>
			<td><input type="checkbox" name="hobby" value="독서">독서 
			<input type="checkbox" name="hobby" value="등산">등산 
			<input type="checkbox" name="hobby" value="운동">운동 
			<input type="checkbox" name="hobby" value="낚시">낚시</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="전송">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
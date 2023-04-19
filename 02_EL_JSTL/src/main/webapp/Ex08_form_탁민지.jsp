<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
Ex08_form_탁민지.jsp<br>

<form action="Ex08_result_탁민지.jsp" method="post">
	<table border="1">
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><input type="text" name="age"></td>
		</tr>
		<tr>
			<td>몸무게</td>
			<td><input type="text" name="weight"></td>
		</tr>
		<tr>
			<td>키</td>
			<td><input type="text" name="height"></td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				<label>남<input type="radio" name="gender" value="남자"></label>
				<label>여<input type="radio" name="gender" value="여자"></label>
			</td>
		</tr>
	</table>
		<tr>
			<td colspan="2"><input type="submit" value="전송하기"></td>
		</tr>
	</table>
</form>

이름 나이 몸무게 키 성별
몸무게 50 이상 키 160 이상만 놀이기구 탑승 가능합니다 출력
리퀘스트 el 빈 출력 5가지 이상
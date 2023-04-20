<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
Ex10_form.jsp<br>

<form action="Ex10_result.jsp" method="post">
	이름 : <input type="text" name="name"><br>
	과일 :
		<input type="checkbox" name="fruit" value="포도">포도
		<input type="checkbox" name="fruit" value="사과">사과
		<input type="checkbox" name="fruit" value="수박">수박
		<input type="checkbox" name="fruit" value="딸기">딸기
		
		<input type="submit" value="전송">
</form>


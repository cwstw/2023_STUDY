<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- label의 for는 input의 id와 연결 -->
alubumInsertForm.jsp<br>

<form action="insert.ab" method="post">
	<p>
		<label for="title">노래제목 :</label>
		<input type="text" name="title" id="title">
	</p>
	<p>
		<label for="singer">가수명 :</label>
		<input type="text" name="singer" id="singer">
	</p>
	<p>
		<label for="price">가격 :</label>
		<input type="text" name="price" id="price">
	</p>
	<p>
		<label for="day">발매일 :</label>
		<input type="text" name="day" id="day">
	</p>
	<p>
		<input type="submit" value="추가하기">
	</p>
</form>
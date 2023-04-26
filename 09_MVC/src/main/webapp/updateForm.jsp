<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
insertForm.jsp<br>
<h2>도서수정</h2>
<form action="update.bk" method="post">
	<input type="hidden" value="${bb.no}">
	제목 : <input type="text" name="title" value="${bb.title }"><br>
	저자 : <input type="text" name="author" value="${bb.author }"><br>
	가격 : <input type="text" name="price" value="${bb.price }"><br>
	<input type="submit" value="등록"><br>
</form>
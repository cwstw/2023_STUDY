<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
Ex02_productInsertForm.jsp<br>
<%
	application.setAttribute("flag", false);
%>
<h3>상품등록</h3>
<form action="insert.prd" method="post">
	상품명 : <input type="text" name="name" value="포도"><br>
	가격 : <input type="text" name="price" value="1000"><br>
	<input type="submit" value="전송">
</form>
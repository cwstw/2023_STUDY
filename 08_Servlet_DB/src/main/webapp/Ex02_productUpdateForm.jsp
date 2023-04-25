<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
Ex02_productUpdateForm.jsp<br>
<h3>상품수정</h3>
<form action="update.prd" method="post">
	<input type="hidden" name="num" value="${pb.num}">
	상품명 : <input type="text" name="name" value="${pb.name}"><br>
	가격 : <input type="text" name="price" value="${pb.price}"><br>
	<input type="submit" value="전송">
</form>
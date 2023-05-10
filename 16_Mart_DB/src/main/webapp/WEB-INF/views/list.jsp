<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
list.jsp<br>

<table border="1">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>패스워드</td>
		<td>구매상품</td>
		<td>배송시간</td>
		<td>결제방법</td>
		<td>결제동의</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
	<c:forEach var="ml" items="${lists}">
	<tr>
		<td>${ml.num}</td>
		<td>${ml.id}</td>
		<td>${ml.pw}</td>
		<td>${ml.product}</td>
		<td>${ml.time}</td>
		<td>${ml.approve}</td>
		<td>${ml.agree}</td>
		<td><a href="updateForm?num='${ml.num}'">수정</a></td>
		<td><a href="delete?num='${ml.num}'">삭제</a></td>
	</tr>
	</c:forEach>
</table>
<br>
<a href="form">삽입</a>

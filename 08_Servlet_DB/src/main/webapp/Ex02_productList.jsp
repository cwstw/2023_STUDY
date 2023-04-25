<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
Ex02_productList.jsp<br>

<table border="1" align="center">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>가격</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	<c:forEach var="i" begin="0" end="${fn:length(requestScope.list)-1 }">
		<tr>
			<td>${list[i].num}</td>
			<td>${list[i].name}</td>
			<td>${list[i].price}</td>
			<td><a href="/delete.prd?num=${list[i].num}">삭제</a></td>
			<td><a href="/updateForm.prd?num=${list[i].num}">수정</a></td>
		</tr>
	</c:forEach>
</table>
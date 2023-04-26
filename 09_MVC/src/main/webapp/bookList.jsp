<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
bookList.jsp<br>

<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>저자</th>
		<th>가격</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	<c:forEach var="bb" items="${list}">
		<tr>
			<td>${bb.no }</td>
			<td>${bb.title }</td>
			<td>${bb.author }</td>
			<td>${bb.price }</td>
			<td><a href="delete.bk?no=${bb.no}">삭제</a></td>
			<td><a href="updateForm.bk?no=${bb.no}">수정</a></td>
		</tr>
	</c:forEach>
</table>
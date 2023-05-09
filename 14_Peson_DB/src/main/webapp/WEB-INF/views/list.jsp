<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
list.jsp<br>
<table border="1">
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>이름</th>
		<th>나이</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="per" items="${list}">
	<tr>
		<th>${per.num}</th>
		<th><a href="updateForm?num=${per.num}">${per.id}</a></th>
		<th>${per.name}</th>
		<th>${per.age}</th>
		<th><a href="delete?num=${per.num }">삭제</a></th>
	</tr>
	</c:forEach>
</table>
<a href="writeform">삽입</a>
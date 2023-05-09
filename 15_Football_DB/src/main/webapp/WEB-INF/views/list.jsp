<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
list.jsp<br>

<table border="1">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>우승 예상 국가</td>
		<td>16강 예상 국가</td>
		<td>삭제</td>
	</tr>
	
	<c:forEach var="foot" items="${list}">
		<tr>
			<td><a href="updateForm?num=${foot.num}">${foot.num}</a></td>
			<td>${foot.id}</td>
			<td>${foot.pw}</td>
			<td>${foot.win}</td>
			<td>${foot.round16}</td>
			<td><a href="delete?num=${foot.num}">삭제</a>
		</tr>
	</c:forEach>	
</table>
<br>
<a href="insert">삽입</a>
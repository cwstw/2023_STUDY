<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
Ex01_memberList.jsp<br><br>

<h3>[회원 목록보기]</h3>

<table border="1" align="center" width="80%">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>비밀번호</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
<c:forEach var="i" begin="0" end="${fn:length(requestScope.mlist)-1}">
	<tr>
		<td>${requestScope.mlist[i].no}</td>
		<td>${requestScope.mlist[i].name}</td>
		<td>${requestScope.mlist[i].password}</td>
		<td><a href="delete.mb?no=${requestScope.mlist[i].no}">삭제</a></td>
		<td><a href="updateForm.mb?no=${requestScope.mlist[i].no}">수정</a></td>
	</tr>
</c:forEach>
</table>
<hr>
<a href="Ex01_memberForm.jsp">삽입</a>
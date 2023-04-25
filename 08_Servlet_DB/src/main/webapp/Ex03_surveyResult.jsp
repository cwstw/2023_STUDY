<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
Ex03_surveyResult.jsp<br>
<%
	application.setAttribute("flag", "false");
%>
<table border="1">
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>소속회사</th>
		<th>이메일 주소</th>
		<th>과정 만족도</th>
		<th>관심 분야</th>
		<th>정보 발송 방법</th>
		<th>정보 발송 동의</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	<c:forEach var="i" begin="0" end="${fn:length(requestScope.list)-1}">
	<tr>
		<td>${list[i].no}</td>
		<td>${list[i].name}</td>
		<td>${list[i].company}</td>
		<td>${list[i].email}</td>
		<td>${list[i].satisfaction}</td>
		<td>${list[i].part}</td>
		<td>${list[i].howto}</td>
		<td>
			<c:if test="${not (list[i].agree eq 0)}">
				동의함
			</c:if>
			<c:if test="${list[i].agree eq 0}">
				동의안함
			</c:if>
		</td>
		<td><a href="delete.sv?no=${list[i].no}">삭제</a></td>
		<td><a href="updateForm.sv?no=${list[i].no}">수정</a></td>
	</tr>
	</c:forEach>
</table>
<a href="Ex03_surveyInsertForm.jsp">등록</a>
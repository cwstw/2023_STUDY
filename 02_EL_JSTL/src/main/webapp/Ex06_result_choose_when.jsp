<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
Ex06_result_choose_when.jsp<br>
<%
	request.setCharacterEncoding("UTF-8");
%>
선택한 음식 : ${param.food}<br>

<c:if test="${param.food=='피자' }">
	피자
</c:if>
<c:if test="${param.food=='호빵' }">
	호빵
</c:if>
<c:if test="${param.food=='치킨' }">
	치킨
</c:if>
<c:if test="${param.food=='삼겹살' }">
	삼겹살
</c:if>

<hr>

<c:choose>
	<c:when test="${param.food=='피자'}">
		피자
	</c:when>
	<c:when test="${param.food=='호빵'}">
		호빵
	</c:when>
	<c:when test="${param.food=='삼겹살'}">
		삼겹살
	</c:when>
	<c:otherwise>
		그 밖의 음식
	</c:otherwise>
</c:choose>




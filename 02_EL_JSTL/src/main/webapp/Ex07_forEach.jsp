<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
Ex07_forEach.jsp<br>
<c:set var="sum" value="0"/>
<c:forEach var="cnt" begin="1" end="10" step="2" varStatus="status">
	${cnt}
	<c:set var="sum" value="${sum+cnt}"/>
</c:forEach><br>
합계 : ${sum}<br>
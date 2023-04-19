<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
Ex08_result_탁민지.jsp<br>
<%
	request.setCharacterEncoding("UTF-8");
	out.print("[출력1]<br>");
	out.print(request.getParameter("name")+"<Br>");
	out.print(request.getParameter("age")+"<Br>");
	out.print(request.getParameter("weight")+"<Br>");
	out.print(request.getParameter("height")+"<Br>");
	out.print(request.getParameter("gender")+"<Br>");
%>
<jsp:useBean id="pb" class="myPkg.ParkBean"/>
<jsp:setProperty property="*" name="pb"/>
<Br>
[출력2]<br>
${pb.name}<br>
${pb.age}<br>
${pb.weight}<br>
${pb.height}<br>
${pb.gender}<br>
<br>
[출력3]<Br>
<jsp:getProperty property="name" name="pb"/><br>
<jsp:getProperty property="age" name="pb"/><br>
<jsp:getProperty property="weight" name="pb"/><br>
<jsp:getProperty property="height" name="pb"/><br>
<jsp:getProperty property="gender" name="pb"/><br>
<br>
[출력4]<Br>
${param.name }<br>
${param.age }<br>
${param.weight }<br>
${param.height }<br>
${param.gender }<br>
<br>
[출력5]<br>
<c:out value="${param.name }"/><br>
<c:out value="${param.age }"/><br>
<c:out value="${param.weight }"/><br>
<c:out value="${param.height }"/><br>
<c:out value="${param.gender }"/><br>
<br>
[조건문]<br>
<c:if test="${param.weight>=50 and param.height>=160 }">
	놀이기구 탑승 가능합니다.<br>
</c:if>
<br>
<c:choose>
	<c:when test="${param.weight>=50 and param.height>=160 }">
		놀이기구 탑승 가능합니다.<br>
	</c:when>
	<c:otherwise>
		놀이기구 탑승 불가합니다.<br>
	</c:otherwise>
</c:choose>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
Ex08_result_탁민지.jsp<br>
<jsp:useBean id="pb" class="myPkg.ParkBean"/>
<jsp:setProperty property="*" name="pb"/>
<jsp:useBean id="pkb" class="myPkg.ParkBean"/>
<jsp:setProperty name="pkb" property="*"/>
<c:if test="${param.name==''}">
	파라미터 == ''
</c:if><br>
<c:if test="${pkb.name==null}">
	pb == null
</c:if><Br>
<Br>
<c:if test="${param.gender==null }">
	파람 ==null
</c:if><br>
<c:if test="${pkb.gender==null }">
	게터 ==null
</c:if><br><br>

<c:if test="${fn:length(paramValues.hobby)==0}">
	길이 == 0
</c:if><br>
<c:if test="${paramValues.hobby==''}">
	paramValues.hobby==''
</c:if><br>
<c:if test="${paramValues.hobby==null}">
	paramValues.hobby==null
</c:if><br>
<%-- <c:if test="${pkb.hobby==''}">
	pkb.hobby==''
</c:if><br>
<c:if test="${pkb.hobby==null}">
	pkb.hobby==null
</c:if><br> --%>

<c:if test="${empty param.hobby }">
	empty
</c:if>
<hr>
<%
	request.setCharacterEncoding("UTF-8");
	out.print("[출력1]<br>");
	out.print(request.getParameter("name")+"<Br>");
	out.print(request.getParameter("age")+"<Br>");
	out.print(request.getParameter("weight")+"<Br>");
	out.print(request.getParameter("height")+"<Br>");
	out.print(request.getParameter("gender")+"<Br>");
%>
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
<hr>
<br>
[취미]<br>
<c:forEach var="hobby" items="${paramValues.hobby }" varStatus="st">
	${hobby}
	<c:if test="${not st.last}"> , </c:if>
</c:forEach><br>

[주소]<br>
<c:if test="${param.addr eq '선택' }">
	선택한 주소가 없습니다.
</c:if>
<c:if test="${not (param.addr eq '선택') }">
	${param.addr}
</c:if>
<br>

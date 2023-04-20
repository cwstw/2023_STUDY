<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
Ex10_result.jsp<br>
<%
	request.setCharacterEncoding("UTF-8");
%>
이름 : ${param.name}<br>
과일 : ${param.fruit}<Br>

<%
	String name = request.getParameter("name");
	String[] fruit = request.getParameterValues("fruit");
%>
이름 : <%=name%><br>
과일 : <%=fruit%><br>
과일 : 
<%
	for(String f : fruit){
		out.print(f+" ");
	}
%><br><br>
과일 : ${paramValues.fruit}<br>
선택한 과일 갯수 : ${fn:length(paramValues.fruit)}<br>

[일반 for]
<c:forEach var="i" begin="0" end="${fn:length(paramValues.fruit)-1}" step="1">
	${paramValues.fruit[i]}
</c:forEach><br>

[확장 for]
<c:forEach var="f" items="${paramValues.fruit}" varStatus="status">
	${f}/${status.first}/${status.last}
</c:forEach><br>
<br>
[쉼표 출력]
<c:forEach var="f" items="${paramValues.fruit}" varStatus="status">
	${f}
	<c:if test="${not status.last}">
		,
	</c:if>
</c:forEach><br>
<br>
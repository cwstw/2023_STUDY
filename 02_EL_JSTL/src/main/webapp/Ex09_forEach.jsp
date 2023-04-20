<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
Ex09_forEach.jsp<br>
<c:forEach var="i" begin="1" end="10" step="1">
	${cnt}
</c:forEach><br>

<%
	String[] movieList = {"슬램덩크","스즈메의문단속","아바타","에에올"};
	for(int i=0;i<movieList.length;i++){
		out.print(movieList[i]+" ");
	}
%><br>
<%
	for(String movie : movieList){
		out.print(movie+" ");
	}
%>
<hr>
<c:set var="mlist" value="<%=movieList %>"/>
<c:forEach var="i" begin="0" end="3" step="1">
	<%-- ${movieList[i]} --%>
	${mlist[i]}
</c:forEach><br>
배열의 길이 : ${fn:length(mlist)}<br>

<%
	pageContext.setAttribute("mlist2",movieList);
	//request.setAttribute();
%>
<c:forEach var="i" begin="0" end="${fn:length(mlist)-1}" step="1">
	<%-- ${movieList[i]} --%>
	${mlist2[i]}
</c:forEach><br>

<c:forEach var="movie" items="${mlist }">
	${movie }
</c:forEach>

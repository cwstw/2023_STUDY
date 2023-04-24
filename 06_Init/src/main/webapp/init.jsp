<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
init.jsp<br>
[el]<br>
${initParam.company}<Br>
${initParam.singer}<Br>

[jsp]<br>
<%=application.getInitParameter("company")%><br>
<%=application.getInitParameter("singer")%><br>

[jsp]<br>
<%=application.getInitParameter("company")%><br>
<%=application.getInitParameter("singer")%><br>
<%
	config.getInitParameter("abc");
%>
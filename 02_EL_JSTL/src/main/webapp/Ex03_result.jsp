<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
Ex03_result.jsp
<%
	int num1 = Integer.parseInt(request.getParameter("num1"));
	int num2 = Integer.parseInt(request.getParameter("num2"));
%>

숫자1 : <%=num1+"+"+num2+"="+(num1+num2) %><br>
숫자3 : ${param.num1}+${param["num2"]}=${param.num1 eq param.num2}
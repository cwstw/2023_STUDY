<%@ page import="com.spring.ex.PersonBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result1.jsp<br>

name1 : <%=request.getParameter("name") %>
name2 : ${param.name}
name3 : ${name}

age1 : <%=request.getParameter("age") %>
age2 : ${param.age}
age3 : ${age}
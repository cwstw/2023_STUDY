<%@page import="com.spring.ex.PersonBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result5.jsp<br>

id : ${abcd.id}
id : ${requestScope.abcd.id}
id : ${abcd["id"]}
id : ${abcd['id']}
id : <%=((PersonBean)request.getAttribute("abcd")).getId()%>
id : <%=request.getParameter("id")%>
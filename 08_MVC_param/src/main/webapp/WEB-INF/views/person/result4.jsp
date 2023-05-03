<%@page import="com.spring.ex.PersonBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result4.jsp<br>

id : ${pesrsonBean.id}
id : ${requestScope.pesrsonBean.id}
id : ${pesrsonBean["id"]}
id : ${pesrsonBean['id']}
id : <%=((PersonBean)request.getAttribute("personBean")).getId()%>
id : <%=request.getParameter("id")%>
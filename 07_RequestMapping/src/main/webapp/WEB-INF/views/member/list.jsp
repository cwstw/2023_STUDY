<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
list.jsp<br>

이름1 : <%=request.getParameter("name") %><!-- null -->
이름2 : <%=request.getAttribute("name") %>
이름3 : ${param.name }<!-- 공백 -->
이름4 : ${requestScope.name }
이름5 : ${name}

나이1 : <%=request.getParameter("age") %><!-- null -->
나이2 : <%=request.getAttribute("age") %>
나이3 : ${param.age }<!-- 공백 -->
나이4 : ${requestScope.age }
나이5 : ${age}

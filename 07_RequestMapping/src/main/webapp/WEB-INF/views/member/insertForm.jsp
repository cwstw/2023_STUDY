<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
member\insertForm.jsp<br>

id1 : <%=request.getParameter("id") %><br> <!-- null -->
id2 : <%=request.getAttribute("id") %><br>
id3 : ${param.id}<br> <!-- 공백 -->
id4 : ${requestScope.id}<Br>
id5 : ${id}

pw1 : <%=request.getParameter("pw") %><br> <!-- null -->
pw2 : <%=request.getAttribute("pw") %><br>
pw3 : ${param.pw}<br> <!-- 공백 -->
pw4 : ${requestScope.pw}<Br>
pw5 : ${pw}
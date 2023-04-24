<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
basic.jsp<br><br>
<!-- http://localhost:8080/07_URLPattern/WEB-INF/basic.jsp -->
<a href="insert.do">insert</a>
<br>
<hr>
<a href="http://localhost:8080<%=request.getContextPath() %>/update.do">update</a>
<br>
<hr>
<a href="http://localhost:8080/07_URLPattern/delete.do">delete</a>
<br>
<hr>
<a href="<%=request.getContextPath() %>/select.do">select</a>
<br>
<hr>

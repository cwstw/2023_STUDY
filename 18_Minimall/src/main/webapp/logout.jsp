<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- logout.jsp -->

<%
	session.invalidate();//��缼�� ����
%>
<script>
	location.href="main.jsp";
</script>
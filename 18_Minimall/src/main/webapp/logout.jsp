<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- logout.jsp -->

<%
	session.invalidate();//모든세션 해제
%>
<script>
	location.href="main.jsp";
</script>
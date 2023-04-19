<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.print("age : "+application.getAttribute("a_age")+"<br>");
%>
	HELLO<br>
	<%="HELLO" %><br>
	<%out.print("HELLO"); %><br>
	${"Hello"}<br>
	\${ 3+4 } = ${ 3+4 }<br>
	${ "3"+"4" }<br>
	${ "3+4" }<br>
	${ 10==20 } = ${ 10 eq 20 }<br>
	${ 10!=20 } = ${ 10 ne 20 }<br>
	
</body>
</html> 
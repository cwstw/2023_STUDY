<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] hobby = request.getParameterValues("hobby");
%>
result.jsp<br>
이름 : ${param.name} <br>
나이 : ${param.age} <br>
성별 : ${param.gender} <br>
취미 : 
	<%for(String h : hobby){ 
		out.print(h+" ");
	}%>
<!-- 객체에 toString이 없으면 주소값이 나온다. -->
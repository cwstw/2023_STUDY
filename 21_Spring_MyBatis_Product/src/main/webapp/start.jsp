<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
start.jsp<br>
<%
	String viewProduct="list.prd";
	String viewMember="list.mb";
// /넣으면 ex가 빠짐, contextpath는 ex까지 가져와서 /붙여야 함
%>

<a href="<%=viewProduct%>">상품 목록 보기</a> <br><br>
<a href="<%=viewMember%>">회원 목록 보기</a> <br><br>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
start.jsp<br>
<%
	String viewProduct="list.prd";
	String viewMember="list.mb";
	String viewCart="list.mall";
	String viewOrder="order.mall";
// /넣으면 ex가 빠짐, contextpath는 ex까지 가져와서 /붙여야 함
%>

<a href="<%=viewProduct%>">상품 목록 보기</a> <br><br>
<a href="<%=viewCart%>">장바구니 보기</a> <br><br>
<a href="<%=viewOrder%>">주문 내역 보기</a> <br><br>
<a href="<%=viewMember%>">회원 목록 보기</a> <br><br>
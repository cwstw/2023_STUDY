<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css">   
<!-- myshop\admin\top.jsp<br> -->
<style>
	body{
		text-align: center;
	}
	table{
		margin : auto;
	}
</style>
<font size=6>쇼핑몰(관리자용)</font><br><br>
<a href="main.jsp">쇼핑몰홈</a>
<a href="<%=request.getContextPath()%>/main.jsp">로그인</a>
<a href="<%=request.getContextPath()%>/logout.jsp">로그아웃</a>
<br><br>
<table border="1" width="800" height="400">
	<tr height="40">
		<td align="center">
			<a href="category_input.jsp">카테고리 등록</a>
		</td>
		<td align="center">
			<a href="category_list.jsp">카테고리 목록</a>
		</td>
		<td align="center">
			<a href="product_input.jsp">상품 등록</a>
		</td>
		<td align="center">
			<a href="">상품 목록</a>
		</td>
		<td align="center">
			<a href="shopping_list.jsp">쇼핑 내역</a>
		</td>
		<td align="center">
			<a href="<%=request.getContextPath()%>/myshop/display/mall.jsp">사용자 홈</a>
		</td>
	</tr>
	<tr height="300">
	


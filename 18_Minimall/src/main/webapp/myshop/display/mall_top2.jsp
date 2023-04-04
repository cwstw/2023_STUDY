<%@page import="my.shop.CategoryDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="my.shop.CategoryBean"%>
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
	.right{
		float : right;
	}
	.menu{
		align : center;
	}
</style>

<%
	String conPath = request.getContextPath();
	CategoryDAO cdao = CategoryDAO.getInstance();
	ArrayList<CategoryBean> lists = cdao.getAllCategory();
	//세션은 오브젝트를 리턴, 스트링으로 받기 위해 다운캐스팅
	String sid = (String)session.getAttribute("sid");
%>

<a href="main.jsp">쇼핑몰홈</a>

<br><br>
<table border="1" width="800" height="400">
	<tr hight="30">
		<th colspan="2">
			<!-- 메뉴 -->
			<a href="<%=conPath %>/main.jsp" class="menu">HOME</a> |
			<% if(sid.equals("admin")){%>
				<a href="<%=conPath %>/myshop/admin/main.jsp" class="menu">관리자홈</a> |
			<%}%>
			<a href="<%=conPath%>/myshop/display/mall.jsp" class="menu">쇼핑몰홈</a> |
			<a href="mall_<%=conPath%>/myshop/display/cartList.jsp" class="menu">장바구니</a> |
			<a href="<%=conPath%>/myshop/board/select.jsp" class="menu">게시판</a> |
			<a href="<%=conPath%>/myshop/display/company.jsp" class="menu">회사소개</a>
			
			<!-- 로그아웃 위에 있는 게 먼저 오른쪽 배치 -->
			<a href="<%=conPath%>/logout.jsp" class="right">
				<img src="<%=request.getContextPath()%>/myshop/images/logout3.jpg" width="50px">
			</a>
			<span class="right"><%=sid%>님</span>
		</th>
	</tr>
	
	<tr>
		<th width="20%" align="center">
			<table width="100%" align="center" border="1">
				<tr>
					<td>
						<a href="<%=conPath%>/myshop/display/ceo.jsp">CEO 인사말</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="<%=conPath%>/myshop/display/history.jsp">회사 연혁</a>
					</td>
				</tr>
				<tr>
					<td>
						<a href="<%=conPath%>/myshop/display/chart.jsp">조직도</a>
					</td>
				</tr>
			</table>
		</th>
		<td>

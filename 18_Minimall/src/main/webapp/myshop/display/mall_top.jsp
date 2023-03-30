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
			<a href="mall.jsp" class="menu">쇼핑몰홈</a> |
			<a href="" class="menu">장바구니</a> |
			<a href="" class="menu">게시판</a> |
			<a href="" class="menu">회사소개</a>
			
			<!-- 로그아웃 위에 있는 게 먼저 오른쪽 배치 -->
			<a href="<%=conPath%>/logout.jsp" class="right">
				<img src="<%=request.getContextPath()%>/myshop/images/logout3.jpg" >
			</a>
			<span class="right"><%=sid%>님</span>
		</th>
	</tr>
	
	<tr>
		<th width="20%" align="center">
			<font color="blue">카테고리</font>
			<table border="1" name="category">
				<%for(CategoryBean cb : lists){%>
					<td>
						<a href=""><%=cb.getCname()%>[<%=cb.getCode()%>]</a>
					</td>	
				<%}%>
			</table>
		</th>
		<td>

<%@page import="my.shop.ProductBean"%>
<%@page import="my.shop.ProductDAO"%>
<%@page import="my.shop.mall.CartBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- mall_cartAdd.jsp -->
<%
	String pnum = request.getParameter("pnum");
	String oqty = request.getParameter("oqty");
	//CartBean mallCart = new CartBean();
%>
<!-- scope=page : 현재 페이지에서만 객체 유지 session : 계속 유지 -->
<jsp:useBean id="mallCart" class="my.shop.mall.CartBean" scope="session"/>

<%
	ProductDAO pdao = ProductDAO.getInstance();
	ProductBean pb = pdao.getProductByPnum(pnum);
	
	mallCart.addProduct(pnum, oqty); 
	//잠시 거쳐가는 페이지
	response.sendRedirect("mall_cartList.jsp");
%>
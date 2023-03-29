<%@page import="my.shop.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- product_delete.jsp -->
<%
	String pnum = request.getParameter("pnum");
	ProductDAO pdao = ProductDAO.getInstance();
	int cnt = pdao.deleteProduct(pnum); 
	
	String msg="";
	
	if(cnt > 0){
		msg="삭제 성공";
	} else{
		msg="삭제 실패";
	}
%>
<script>
	alert("<%=msg%>");
	location.href="product_list.jsp";
</script>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--mall_cartList.jsp(상품번호, 수정할 주문수량) => mall_cartEdit.jsp -->
<jsp:useBean id="mallCart" class="my.shop.mall.CartBean" scope="session"/>
<%
	String pnum = request.getParameter("pnum");
	String oqty = request.getParameter("oqty");
	
	mallCart.setEdit(pnum,oqty); 
%>
<script>
	alert("수정되었습니다.");
	location.href="mall_cartList.jsp";
</script>

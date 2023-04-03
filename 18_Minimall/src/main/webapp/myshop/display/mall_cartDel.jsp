<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- mall_cartList.jsp(pnum) => mall_cartdel.jsp
장바구니에서 삭제하고 다시 목록보기로 돌아가기-->
<jsp:useBean id="mallCart" class="my.shop.mall.CartBean" scope="session"/>
<%
	String pnum = request.getParameter("pnum");
	
	mallCart.removeProduct(pnum);
%>
<script>
	alert("삭제되었습니다.");
	location.href="mall_cartList.jsp";
</script>


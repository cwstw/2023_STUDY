<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--mall_cartList.jsp(��ǰ��ȣ, ������ �ֹ�����) => mall_cartEdit.jsp -->
<jsp:useBean id="mallCart" class="my.shop.mall.CartBean" scope="session"/>
<%
	String pnum = request.getParameter("pnum");
	String oqty = request.getParameter("oqty");
	
	mallCart.setEdit(pnum,oqty); 
%>
<script>
	alert("�����Ǿ����ϴ�.");
	location.href="mall_cartList.jsp";
</script>

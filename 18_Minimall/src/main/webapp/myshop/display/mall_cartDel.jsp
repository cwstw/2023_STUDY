<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- mall_cartList.jsp(pnum) => mall_cartdel.jsp
��ٱ��Ͽ��� �����ϰ� �ٽ� ��Ϻ���� ���ư���-->
<jsp:useBean id="mallCart" class="my.shop.mall.CartBean" scope="session"/>
<%
	String pnum = request.getParameter("pnum");
	
	mallCart.removeProduct(pnum);
%>
<script>
	alert("�����Ǿ����ϴ�.");
	location.href="mall_cartList.jsp";
</script>


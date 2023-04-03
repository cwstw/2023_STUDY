<%@page import="my.shop.mall.OrdersDAO"%>
<%@page import="my.shop.ProductBean"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- mall_order.jsp => mall_calculate.jsp -->
<link rel="stylesheet" type="text/css" href="style.css">
<jsp:useBean id="mallCart" class="my.shop.mall.CartBean" scope="session"/>

<%
	Vector<ProductBean> clist = mallCart.getAllProducts();
	
	//오브젝트를 인티저로 다운캐스팅
	int sno = (Integer)session.getAttribute("sno");
	OrdersDAO odao = OrdersDAO.getInstance();
	int cnt = odao.insertOrder(sno,clist);//회원번호,장바구니 
	
	String msg="",url="";
	if(cnt > 0){
		msg="주문 완료";
		url="mall.jsp";
		mallCart.removeAllProduct();//장바구니 상품 모두 삭제
	}else{
		msg="주문 실패";
		url="mall.jsp";
	}	
%>
<script>
	alert("<%=msg%>했습니다.");
	location.href="<%=url%>";
</script>

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
	
	//������Ʈ�� ��Ƽ���� �ٿ�ĳ����
	int sno = (Integer)session.getAttribute("sno");
	OrdersDAO odao = OrdersDAO.getInstance();
	int cnt = odao.insertOrder(sno,clist);//ȸ����ȣ,��ٱ��� 
	
	String msg="",url="";
	if(cnt >= 0){
		msg="�ֹ� �Ϸ�";
		url="mall.jsp";
		mallCart.removeAllProduct();//��ٱ��� ��ǰ ��� ����
	%>
	<script>
		alert("<%=msg%>�߽��ϴ�.");
		var resp = confirm("����Ͻðڽ��ϱ�?");
		
		if(resp){
			location.href="mall.jsp"
		}else{
			location.href="<%=request.getContextPath() %>/logout.jsp";
		}//else
</script>
	<%
	}else{
		msg="�ֹ� ����";
		url="mall.jsp";
	}	
%>
<script>
	alert("<%=msg%>�߽��ϴ�.");
	location.href="<%=url%>";
</script>

<%@page import="java.util.Vector"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="my.shop.ProductBean"%>
<%@page import="my.shop.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- mall_cartList.jsp() => mall_order.jsp -->

<link rel="stylesheet" type="text/css" href="style.css">
<jsp:useBean id="mallCart" class="my.shop.mall.CartBean" scope="session"/>
<%
	String pnum = request.getParameter("pnum");	
	String oqty = request.getParameter("oqty");	
	if(!pnum.equals("00") && !oqty.equals("00")){
		return;
	}
	mallCart.addProduct(pnum, oqty);
	
	Vector<ProductBean> clist = mallCart.getAllProducts();
	DecimalFormat df = new DecimalFormat("###,###");
	
	int totalPrice = 0;
	
%>
<jsp:include page ="mall_top.jsp"/>
<table border="1" width="90%" class="outline">
	<tr class="m2" height="60">
		<td colspan="3" align="center">
			<b>결제 내역서 보기</b>
		</td>
	</tr>
	<tr class="m1">
		<th align="center">상품명</th>
		<th align="center" width="20%">수량</th>
		<th align="center" width="30%">금액</th>
	</tr>
	<%
		if(clist.size()==0){
			out.println("<tr><th colspan='3'>");
			out.println("결제할 상품이 없습니다.</th></tr></table>");
		}else{
	
			for(int i=0;i<clist.size();i++){ %>
			<tr>
				<td align="center"><%=pb.getPname() %></td>
				<td align="right"><%=pb.getPqty() %></td>
				<td align="right"><%=df.format(pb.getPrice()*pb.getPqty())%>원</td>
			</tr>
		<%
			totalPrice = pb.getPrice()*pb.getPqty();
			}//for	
		%>
			<tr>
				<td colspan="3">
					<font color="blue">결제하실 총액은 : </font>
					<font color="red"><%=df.format(totalPrice) %>원</font>
				</td>
			</tr>
		</table>
			<input type="button" value="결제하기" onCLick="location.href='mall_calculate.jsp'">
	<% }//else%>
<jsp:include page="mall_bottom.jsp"/>
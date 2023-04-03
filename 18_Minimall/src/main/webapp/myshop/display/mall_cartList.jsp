<%@page import="java.text.DecimalFormat"%>
<%@page import="my.shop.ProductBean"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" type="text/css" href="style.css">
<!-- mall_cartAdd.jsp => mall_cartList.jsp -->
<!-- 이전에 생성된 객체 그대로 가져옴 -->
<jsp:useBean id="mallCart" class="my.shop.mall.CartBean" scope="session"/>
<%
	Vector<ProductBean> cv = mallCart.getAllProducts();
	
	DecimalFormat df = new DecimalFormat("###,###");
	
	int cartTotalPrice =0;
	int cartTotalPoint =0;
	
%>
<jsp:include page ="mall_top.jsp"/>
<table border="1" width="100%">
	<tr class="m2" height="60">
		<td colspan="6" align="center">
			<b>장바구니 보기</b>
		</td>
	</tr>
	<tr>
		<th align="center">번호</th>
		<th align="center">상품명</th>
		<th align="center">수량</th>
		<th align="center">단가</th>
		<th align="center">금액</th>
		<th align="center">삭제</th>
	</tr>
	<%
		if(cv.size()==0){
			out.println("<tr><th colspan='6'>");
			out.println("장바구니에 담은 상품이 없습니다.</th></tr></table>");
		}else{
	
			for(int i=0;i<cv.size();i++){ %>
			<tr>
				<td align="center"><%=pb.getPnum() %></td>
				<td align="center">
					<img src="<%=imgPath %>" width="" height=""><br>
					<%=pb.getPname() %>
				</td>
				<td align="center">
					<form name="f" method="post" action="">
						<input type="text" name="oqty" value="<%=pb.getPqty() %>" size="2">
						<input type="button" name="updateoqty" value="수정">				
					</form>
				</td>
				<td align="center">
					<b>
						<%=df.format(pb.getPrice())%>원<br>
						[<%=df.format(pb.getPoint())%>] point
					</b>	
				</td>
				<td align="center">
					<b>
						<%=df.format(cv.getPrice()*pb.getPqty()) %>원<br>
						[<%=df.format(cv.getPointpb.getPqty()) %>] point
					</b>	
				</td>
				<td align="center">
					<font color="red">
						<a herf="">삭제</a>
					</font>
				</td>
			</tr>
		<%
			cartTotalPrice = cv.getPrice()*pb.getPqty();
			cartTotalPoint = cv.getPoint()*pb.getPqty();
			}//for	
		%>
			<tr>
				<td colspan="4">
					<font color="blue">장바구니 총액 : </font>
					<font color="red"><%=df.format(cartTotalPrice) %>원</font><br>
					<font color="green">총 적립 포인트 : [<%=df.format(cartTotalPoint) %>] point</font><br>
				</td>
				<td colspan="1">
					<a href="">[주문하기]</a>
					<a href="">[계속쇼핑]</a>
				</td>
			</tr>
		</table>
	<% }//else%>
<jsp:include page="mall_bottom.jsp"/>
<%@page import="my.shop.ProductDAO"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="my.shop.ProductBean"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" type="text/css" href="style.css">
<!-- mall_cartAdd.jsp => mall_cartList.jsp -->
<!-- ì´ì ì ìì±ë ê°ì²´ ê·¸ëë¡ ê°ì ¸ì´ -->
<jsp:useBean id="mallCart" class="my.shop.mall.CartBean" scope="session"/>
<%
	String pnum = request.getParameter("pnum");

	Vector<ProductBean> cv = mallCart.getAllProducts();
	
	ProductDAO pdao = ProductDAO.getInstance();
	ProductBean pb = pdao.getProductByPnum(pnum);
	DecimalFormat df = new DecimalFormat("###,###");
	
	String imgPath = request.getContextPath()+"/myshop/images/"+pb.getPimage();
	int cartTotalPrice =0;
	int cartTotalPoint =0;
	
%>
<jsp:include page ="mall_top.jsp"/>
<table border="1" width="100%">
	<tr class="m2" height="60">
		<td colspan="6" align="center">
			<b>ì¥ë°êµ¬ë ë³´ê¸°</b>
		</td>
	</tr>
	<tr>
		<th align="center">ë²í¸</th>
		<th align="center">ìíëª</th>
		<th align="center">ìë</th>
		<th align="center">ë¨ê°</th>
		<th align="center">ê¸ì¡</th>
		<th align="center">ì­ì </th>
	</tr>
	<%
		if(cv.size()==0){
			out.println("<tr><th colspan='6'>");
			out.println("ì¥ë°êµ¬ëì ë´ì ìíì´ ììµëë¤.</th></tr></table>");
		}else{
	
			for(int i=0;i<cv.size();i++){ %>
			<tr>
				<td align="center"><%=pb.getPnum() %></td>
				<td align="center">
					<img src="<%=imgPath %>" width="" height=""><br>
					<%=pb.getPname() %>
				</td>
				<td align="center">
					<form name="f" method="post" action="mall_cartEdit.jsp">
						<input type="text" name="oqty" value="<%=pb.getPqty() %>" size="2">
						<input type="hidden" name="pnum" value="<%=pb.getPnum() %>">
						<input type="submit" value="수정">				
					</form>
				</td>
				<td align="center">
					<b>
						<%=df.format(pb.getPrice())%>ì<br>
						[<%=df.format(pb.getPoint())%>] point
					</b>	
				</td>
				<td align="center">
					<b>
						<%=df.format(pb.getPrice()*pb.getPqty()) %>ì<br>
						[<%=df.format(pb.getPoint()*pb.getPqty()) %>] point
					</b>	
				</td>
				<td align="center">
					<font color="red">
						<a herf="mall_cartdel.jsp?pnum=<%=pb.getPnum()%>">삭제</a>
					</font>
				</td>
			</tr>
		<%
			cartTotalPrice = pb.getPrice()*pb.getPqty();
			cartTotalPoint = pb.getPoint()*pb.getPqty();
			}//for	
		%>
			<tr>
				<td colspan="4">
					<font color="blue">ì¥ë°êµ¬ë ì´ì¡ : </font>
					<font color="red"><%=df.format(cartTotalPrice) %>ì</font><br>
					<font color="green">ì´ ì ë¦½ í¬ì¸í¸ : [<%=df.format(cartTotalPoint) %>] point</font><br>
				</td>
				<td colspan="1">
					<!-- 딱히 보낼 건 없지만 0이라도 보내주어야 함 -->
					<a href="mall_order.jsp?pnum=00&oqty=00">[주문하기]</a>
					<a href="javascript:history.go(-2)">[계속쇼핑]</a>
				</td>
			</tr>
		</table>
	<% }//else%>
<jsp:include page="mall_bottom.jsp"/>
<%@page import="java.text.DecimalFormat"%>
<%@page import="my.shop.ProductBean"%>
<%@page import="my.shop.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" type="text/css" href="style.css">	
<!-- mall.jsp(pnum) => mall_prodView.jsp -->
<%
	String pnum = request.getParameter("pnum");
	ProductDAO pdao = ProductDAO.getInstance();
	ProductBean pb = pdao.getProductByPnum(pnum);
	DecimalFormat df = new DecimalFormat("###,###");
	
	String imgPath = request.getContextPath()+"/myshop/images/"+pb.getPimage();
%>
<table border="0" class="outline">
	<tr align="center">
		<th colspan="2">[<%=pb.getPname() %>] 상품 정보</th>
	</tr>
	<tr>
		<td><img src="<%=imgPath %>" width="80" height="40"></td>
		<td>
			<form method="post" action="">
			상품번호 : <%=pnum %><br>
			상품이름 : <%=pb.getPname() %><br>
			상품가격 : <font color="red"><strong><%=df.format(pb.getPrice()) %></strong></font>원<br>
			상품포인트 : <font color="red"><strong>[<%=df.format(pb.getPoint()) %>]</strong></font>point<br>
			상품갯수 : <input type="text" name="oqty" size="2" value="1">개<br><br>
			<table width="90%" align="center">
				<tr>
					<td><a href=""><img src="<%=request.getContextPath()%>/myshop/images/cartbtn.gif" width="90" height="30"></a></td>
					<td><a href=""><img src="<%=request.getContextPath()%>/myshop/images/orderbtn.gif" width="90" height="30"></a></td>
				</tr>
			</table>
			</form>
		</td>
	</tr>
	<tr width="200" align="top">
		<td colspan="2">
			<b>상품 상세설명</b><br>
			<%=pb.getPcontents() %>
		</td>
	</tr>
</table>
<jsp:include page="mall_bottom.jsp"/>
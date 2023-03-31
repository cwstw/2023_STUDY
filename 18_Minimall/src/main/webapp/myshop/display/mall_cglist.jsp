<%@page import="java.text.DecimalFormat"%>
<%@page import="my.shop.ProductDAO"%>
<%@page import="my.shop.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- myshop\display\mall_cglist.jsp<br> -->

<jsp:include page ="mall_top.jsp"/>
<h3>Welcome to My Mall</h3>
<%
	request.setCharacterEncoding("utf-8");
	String cname = request.getParameter("cname");
	String code = request.getParameter("code");
	DecimalFormat df = new DecimalFormat("###,###");
	
	ProductDAO pdao = ProductDAO.getInstance();
	ArrayList<ProductBean> plists = pdao.getProductByCategory(code);
	
	
%>	
	<hr color="green" width="80%">
	<font color="red" size="3"><strong></strong><%=cname %></font>
	<hr color="green" width="80%">
	
<%
	if(plists.size()==0){
		out.print("<b>"+cname+"상품 없습니다.</b><br><br><br>");
	}else{
%>
		<table border="0" width="95%" align="center" cellpadding="0">
		<tr>
		<%
			int count = 0;
			for(ProductBean pb : plists){ 
				//이미지 경로
				count++;
				String imgPath = request.getContextPath()+"/myshop/images/"+pb.getPimage();
		%>
				<td align="center">
					<img src="<%=imgPath %>" width="80" height="40"><br>
					<%=pb.getPname() %><br>
					<font color="red"><%=df.format(pb.getPrice()) %></font>원<br>
					<font color="blue"><%=pb.getPoint() %></font>point<br>
				</td>
		<%
				if(count % 3 == 0){ //한줄에 3개만
					out.println("</tr><tr>");
				}//if
			}//for
		%>
		
		</tr>
		</table>
<%
			}//else
%>
<jsp:include page="mall_bottom.jsp"/>

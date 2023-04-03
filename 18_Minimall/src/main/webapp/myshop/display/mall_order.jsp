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
	//flag = true
	//불린으로 다운캐스팅
	boolean flag = (Boolean)application.getAttribute("flag");
	String pnum = request.getParameter("pnum");	
	String oqty = request.getParameter("oqty");	
	//정보가 계속 남아있어서 새로고침 시 계속 수량이 추가됨
	if(!pnum.equals("00") && !oqty.equals("00")){
		if(flag==true){ //한번 실행 후 다시 오면 false
			mallCart.addProduct(pnum, oqty);
		}//if
		//return;
	}//if
	
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
	
			for(ProductBean pb : clist){ %>
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
	<% }//else
	//플래그를 거짓으로 만들어 다시 추가되지 않게 설정
	application.setAttribute("flag", false);//flag=false;
	%>
<jsp:include page="mall_bottom.jsp"/>
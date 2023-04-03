<%@page import="java.text.DecimalFormat"%>
<%@page import="my.shop.mall.OrdersBean"%>
<%@page import="java.util.Vector"%>
<%@page import="my.shop.mall.OrdersDAO"%>
<%@page import="my.shop.CategoryDAO"%>
<%@page import="my.shop.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>  <!-- 첫줄, 두번째 tr시작   -->

<%
	OrdersDAO odao = OrdersDAO.getInstance();
	DecimalFormat df = new DecimalFormat("###,###");

	String memid = request.getParameter("memid");
	System.out.println("memid : "+memid);	
	
	Vector<OrdersBean> olist=null;
	if(memid != null){//검색어가 있으면
		olist = odao.getOrderList(memid);
	}//if
%>

<!-- shopping_list.jsp -->
	<td colspan="6" align="center" valign="top">
		<table border="1" width="90%">
			<tr bgcolor="yellow">
				<th colspan="5" align="center">
				<form action="shopping_list.jsp" method="post">
					조회할 회원 아이디 입력 :
					<input type="text" size="15" name="memid" value="hong">
					<input type="button" value="내역 조회">
				</form>
				</th>
			</tr>
			<tr>
				<th>고객명</th>
				<th>아이디</th>
				<th>상품명</th>
				<th>수량</th>
				<th>금액</th>
			</tr>
			<%
				int list_total = 0;
				if(olist != null){
				for(OrdersBean ob : olist){
				%>
					<tr>
						<td align="center"><%=ob.getMname() %></td>
						<td align="center"><%=ob.getMid() %></td>
						<td align="center"><%=ob.getPname() %></td>
						<td align="center"><%=ob.getQty() %></td>
						<td align="center"><%=ob.getAmount() %></td>
					</tr>
				<%
				list_total +=ob.getAmount();
					} // for
				}//if
				%>
					<tr>
						<td colspan="4" align="center">총 합</td>
						<td align="right">&#8361;금액</td>
					</tr>
		</table>
	</td>
<%@ include file="bottom.jsp" %> <!-- 두번째 /tr, 세번째 줄   -->












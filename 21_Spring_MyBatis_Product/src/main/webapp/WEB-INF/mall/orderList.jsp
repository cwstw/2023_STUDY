<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../common/common.jsp" %>
orderList.jsp<br>
<center>
<h1>주문 내역</h1>
<table border="1">
	<tr>
		<td colspan="3" align="center">
			주문자 정보 : ${loginInfo.name}(${loginInfo.id})
		</td>
	</tr>
	<tr>
		<th>주문 번호</th>
		<th>주문 일자</th>
		<th>상세보기</th>
	</tr>
	
	<c:if test="${fn:length(lists) == 0}">
	<tr>
		<td colspan="3" align="center">
			주문 정보가 없습니다.
		</td>
	</tr>
	</c:if>
	
	<c:forEach var="order" items="${lists}">
	<tr>
		<td align="center">${order.oid}</td>
		<td>${order.orderdate}</td>
		<td><a href="orderDetail.mall?oid=${order.oid}">상세 보기</a></td>
	</tr>
	</c:forEach>
</table>
</center>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>
<!-- cartList.jsp 장바구니 목록 -->
<center>
	<h2>주문 내역</h2>
	<table border="1">
		<tr>
			<td colspan="5">주문자 정보 : ${slist.pname}(${id})</td>
		</tr>
		<tr>
			<td>상품번호</td>
			<td>상품명</td>
			<td>주문수량</td>
			<td>단가</td>
			<td>금액</td>
		</tr>
		<c:forEach var="sl" items="${slist}">
		<tr>
			<td>${sl.pnum}</td>
			<td>${sl.pname}</td>
			<td>${sl.qty}</td>
			<td>${sl.price}</td>
			<td>${sl.amount}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="3">
				<a href="calculate.mall?num">결제하기</a>
				<a href="">추가주문</a>
			</td>
			<td>총금액 : ${totalAmount}</td>
		</tr>
		
	</table>
</center>
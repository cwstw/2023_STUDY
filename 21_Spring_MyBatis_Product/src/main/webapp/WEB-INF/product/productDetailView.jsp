<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- productDetailView.jsp -->
<center>
	<h2>상품 상세 화면</h2>
	<table border="1">
		<tr>
			<td rowspan="6">
				<img src="<%=request.getContextPath() %>/resources/${productBean.image}" alt="" width="100" height="100">
			</td>
			<td>상품명</td>
			<td>${productBean.name}</td>
		</tr>
		<tr>
			<td>가격</td>
			<td>${productBean.price}</td>
		</tr>
		<tr>
			<td>재고수량</td>
			<td>${productBean.stock}</td>
		</tr>
		<tr>
			<td>설명</td>
			<td>${productBean.contents}</td>
		</tr>
		<tr>
			<td>주문수량</td>
			<td>
				주문수량2
				<input type="text" name="orderCount" value="1">
				<input type="button" value="주문">
			</td>
		</tr>
		<tr>
			<td colspan="2"><a href="list.prd">상품리스트</a></td>
		</tr>
	</table>
	
</center>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="../common/common.jsp"%>
<%
/* 	HttpSession.getAttribute session;
	session.getAttribute("name"); */
%>
productList.jsp<br>
<center>
<h1>상품 리스트 화면</h1>
	<form action="list.prd" method="get">
		<select name="whatColumn">
			<option value="">전체 검색
			<option value="name">상품명</option>
			<option value="contents">설명</option>
		</select> <input type="text" name="keyword"> <input type="submit" value="검색">
	</form>
	<table border="1">
		<tr>
			<td align="right" colspan="6">
				<input type="button" onclick="location.herf='insert.prd'" value="추가하기">
			</td>
		</tr>
		<tr>
			<td>상품번호</td>
			<td>상품명</td>
			<td>설명</td>
			<td>가격</td>
			<td>삭제</td>
			<td>수정</td>
		</tr>
		<c:forEach items="${productLists }" var="product">
			<tr>
				<td>${product.num }</td>
				<td><a href="detail.prd?num=${product.num }&pageNumbmer${pageInfo.pageNumber } ">${product.name }</a></td>
				<td>${product.contents }</td>
				<td>${product.price }</td>
				<td><a href="delet.prd?num=${product.num }&pageNumbmer${pageInfo.pageNumber } ">삭제</a></td>
				<td><a href="update.prd?num=${product.num }&pageNumbmer${pageInfo.pageNumber } ">수정</a></td>
			</tr>
		</c:forEach>
	</table>
	${pageInfo.pagingHtml}
</center>
<br>
<a href="insert.prd">추가하기</a>
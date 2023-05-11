<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
albumList.jsp<br>
<script>
	function insert(){
		location.href="insert.ab"
	}
</script>

<table border="1">
	<tr>
		<td colspan="5" align="right">
			<input type="button" value="추가하기" onClick="insert()">
		</td>
	</tr>
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>가수</td>
		<td>가격</td>
		<td>발매일</td>
	</tr>
	<c:forEach var="al" items="${albumLists}">
	<tr>
		<td>${al.num }</td>
		<td>${al.title }</td>
		<td>${al.singer }</td>
		<td>${al.price }</td>
		<td>${al.day }</td>
	</tr>
	</c:forEach>
</table>
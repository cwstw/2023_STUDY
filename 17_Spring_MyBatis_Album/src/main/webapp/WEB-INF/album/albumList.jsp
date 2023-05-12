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
		<td colspan="7" align="right">
			<input type="button" value="추가하기" onClick="insert()">
		</td>
	</tr>
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>가수</td>
		<td>가격</td>
		<td>발매일</td>
		<td>삭제</td>
		<td>수정</td>
	</tr>
	<c:forEach var="al" items="${albumLists}">
	<tr>
		<td>${al.num }</td>
		<td><a href="detail.ab?num=${al.num }">${al.title }</a></td>
		<td>${al.singer }</td>
		<td>${al.price }</td>
		<td>${al.day }</td>
		<td><a href="delete.ab?num=${al.num}">삭제</a></td>
		<td><a href="update.ab?num=${al.num}">수정</a></td>
	</tr>
	</c:forEach>
</table>
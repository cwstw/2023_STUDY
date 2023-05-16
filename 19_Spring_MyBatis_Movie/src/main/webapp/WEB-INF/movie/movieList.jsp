<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!-- movieList.jsp -->

<center>
<form action="/list.mv" method="get">
	<select name="whatColumn">
		<option value="">전체검색</option>
		<option value="genre">장르검색</option>
		<option value="grade">등급검색</option>
		<option value="actor">배우검색</option>
	</select>
	<input type="text" name="keyword">
	<input type="submit" value="검색">
</form>
<table border="1">
	<tr>
		<th colspan="9">
			<input type="button" value="추가하기" onClick="location.href='#insert.mv'">
		</th>
	</tr>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>대륙</th>
		<th>국가</th>
		<th>장르</th>
		<th>등급</th>
		<th>배우</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	<c:forEach var="mv" items="${lists}">
		<tr>
			<th>${mv.num}</th>
			<th>${mv.name}</th>
			<th>${mv.continent}</th>
			<th>${mv.nation}</th>
			<th>${mv.genre}</th>
			<th>${mv.grade}</th>
			<th>${mv.actor}</th>
			<th><a href="delete?num=${mv.num}&pageNumber=${pageInfo.pageNumber}">삭제</a></th>
			<th><a href="delete?num=${mv.num}&pageNumber=${pageInfo.pageNumber}">수정</a></th>
		</tr>
	</c:forEach>
</table>
</center>
<center>
${pageInfo.getPagingHtml()}
</center>
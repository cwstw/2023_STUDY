<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!-- gameList.jsp -->
<center>
	<form action="list.gm" method="get">
		<select name="searchCol">
			<option value="">전체검색
			<option value="title">제목검색
			<option value="genre">장르검색
		</select>
		<input type="text" name="searchWord">
		<input type="submit" value="검색">
	</form>
	<h2>게임 목록</h2>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>장르</th>
			<th>난이도</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="gl" items="${glist}">
		<tr>
			<td>${gl.num}</td>
			<td>${gl.title}</td>
			<td>${gl.genre}</td>
			<td>${gl.difficulty}</td>
			<td><a href="update.gm?num=${gm.num}&pageNumber=${pageNumber}">수정</a></td>
			<td><a href="delete.gm?num=${gm.num}&pageNumber=${pageNumber}">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
	</center>
<center>
	${pageInfo.getPagingHtml()}
	<br>
	<input type="button" value="추가하기" onClick="location.href='/insert.game'">
</center>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
albumList.jsp<br>
<script>
	function insert(){
		location.href="insert.ab"
	}
</script>
<h2>상품 리스트 화면(전체 레코드 갯수:${pageInfo.getTotalCount})</h2>
<center>
<!-- 
whatColumn=title
whatColumn=singer
keyword=마
keyword=아
 -->
	<form action="list.ab" method="get">
		<select name="whatColumn">
			<option value="">전체검색</option>
			<option value="title">노래제목</option>
			<option value="title">가수명</option>
		</select>
		<input type="text" value="keyword">
		<input type="submit" value="검색">
	</form>
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
		<td>
			<fmt:parseDate var="newDay" value="${al.day }" pattern="yyyy-MM-dd"/>
			<fmt:formatDate var="fNewDay" value="${newDay}" pattern="yyyy-MM-dd"/>
			${fNewDay }
		</td>
		<td><a href="delete.ab?num=${al.num}">삭제</a></td>
		<td><a href="update.ab?num=${al.num}">수정</a></td>
	</tr>
	</c:forEach>
</table>
</center>
<center>
${pageInfo.pagingHtml}
</center>
<!-- 1 2 3 4 5 [다음]
	각 숫자 클릭 시 list.ab 요청
 -->



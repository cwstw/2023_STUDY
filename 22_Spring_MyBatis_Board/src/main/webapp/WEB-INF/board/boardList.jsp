<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>
<link rel="stylesheet" type="text/css" href="../style.css">
<%@include file="../color.jsp" %>
<style>
	body{
		text-align: center;
		background: <%=bodyback_c %>
	}
	table{
		margin:auto;
		width:700px;
	}

</style>
<!-- boardList.jsp -->
<script>
	function insert(){
		location.href="insert.bd";
	}
</script>
<center>
	<h2>게시글 목록</h2>
	<form action="list.bd" method="get">
		<select name="whatColumn">
			<option value="">전체 검색</option>
			<option value="subject">글제목</option>
			<option value="writer">글쓴이</option>
		</select>
		<input type="text" name="keyword">
		<input type="submit" value="검색">
	</form>
	
	글 목록 ( 전체 글 : ${pageInfo.totalCount} ) <br>
	
	<table border="1">
		<tr>
			<td colspan="6" align="right">
				<input type="button" value="추가하기" onClick="insert()">
			</td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>IP</th>
		</tr>
		<c:if test="${pageIngo.totalCount eq 0}">
			<tr>
			<td align="center" bgcolor="<%=value_c%>">
				게시판에 저장된 글이 없습니다.
			</td>
			</tr>
		</c:if>
		<c:forEach var="bl" items="${boardLists}">
			<tr height="30" align="center" bgcolor="<%=value_c%>">
				<td>${bl.num}</td>
				<td align="left" style="padding-left:20px">
					<c:if test="${bl.relevel > 0}">
						<c:set var="wid" value="${20*bl.relevel}"/>
						<img src="resources/images/level.gif" width="${wid}" height="20px">
						<img src="resources/images/re.gif">
					</c:if>
					<a href="content.bd?num=${bl.num}&pageNumber=${pageInfo.pageNumber}">
						${bl.subject}
					</a>
					<c:if test="${bl.readcount >=10 }">
						<img src="resources/images/hot.gif" height="20px">
					</c:if>
				</td>
				<td>${bl.writer}</td>
				<td>
					<fmt:parseDate var="newDate" value="${bl.regdate}" pattern="yyyy-MM-dd"/>
					<fmt:formatDate var="fNewDate" value="${newDate}" pattern="yyyy-MM-dd"/>
					${fNewDate}
				</td>
				<td>${bl.readcount}</td>
				<td>${bl.ip}</td>
			</tr>
		</c:forEach>
	</table>
	
	${pageInfo.pagingHtml}
</center>
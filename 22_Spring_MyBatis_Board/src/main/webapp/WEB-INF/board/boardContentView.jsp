<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>
<%@include file="../color.jsp" %>
<link rel="stylesheet" type="text/css" href="./style.css">
<style>
	body{
		text-align: center;
		background: <%=bodyback_c %>
	}
	table{
		margin:auto;
		width:700px;
		text-align: center;
	}
	th{
		background: <%=value_c%>
	}
</style>

<!-- boardContentView.jsp -->
<h3>글 내용 보기</h3>
<table>
	<tr>
		<th>글번호</th>
		<td>${bb.num }</td>
		<th>조회수</th>
		<td>${bb.readcount }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${bb.writer }</td>
		<th>작성일</th>
		<fmt:parseDate var="newDate" value="${bb.regdate}" pattern="yyyy-MM-dd"/>
		<fmt:formatDate var="fNewDate" value="${newDate}" pattern="yyyy-MM-dd"/>
		<td>${fNewDate}</td>
	</tr>
	<tr>
		<th>글제목</th>
		<td colspan="3">${bb.subject }</td>
	</tr>
	<tr height="100px">
		<th>글내용</th>
		<td colspan="3">
			<pre>${bb.content }</pre>
		</td>
	</tr>
	<tr>
		<th colspan="4" align="right">
			<input type="button" id="update" value="글수정" onClick="location.href='update.bd?num=${bb.num}&pageNumber=${pageNumber}'">
			<input type="button" id="delete" value="글삭제" onClick="location.href='delete.bd?num=${bb.num}&pageNumber=${pageNumber}'">
			<input type="button" id="re" value="답글쓰기" onClick="location.href='reply.bd?ref=${bb.ref}&restep=${bb.restep }&relevel=${bb.relevel }&pageNumber=${pageNumber}&num=${bb.num }'">
			<input type="button" id="select" value="글목록" onClick="location.href='list.bd?pageNumber=${pageNumber}'">
		</th>
	</tr>
</table>
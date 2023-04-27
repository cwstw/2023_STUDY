<%@page import="Board.BoardBean"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <%@include file="color.jsp" %>
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
<!-- ==============style/script============== -->

<h3>글 내용 보기</h3>
<form name="contentForm">
<table>
	<tr>
		<th>글번호</th>
		<td>${article.num}</td>
		<th>조회수</th>
		<td>${article.readcount }</td>
	</tr>
	<tr>
		<th>작성자</th>
		<td>${article.wirter}</td>
		<th>작성일</th>
		<td><%=sdf.format(${article.reg_date) %></td>
	</tr>
	<tr>
		<th>글제목</th>
		<td colspan="3">${article.subject}</td>
	</tr>
	<tr height="100px">
		<th>글내용</th>
		<td colspan="3"><pre>${article.content}</pre></td>
	</tr>
	<tr>
		<th colspan="4" align="right">
			<input type="button" id="update" value="글수정" onClick="updateForm.bd?num=${article.num}&pageNum=${param.pageNum }'">
			<input type="button" id="delete" value="글삭제" onClick="deleteForm.bd?num=${article.num}&pageNum=${param.pageNum }'">
			<input type="button" id="re" value="답글쓰기" onClick="replyForm?ref=${article.ref}&re_step=${article.re_step}&re_level=${article.re_level}&pageNum=${param.pageNum }'">
			<input type="button" id="select" value="글목록" onClick="list.bd">
		</th>
	</tr>
</table>
</form>

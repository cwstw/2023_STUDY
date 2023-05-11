<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
albumDetailView.jsp<br>

<table border="1">
	<tr>
		<td>번호</td>
		<td>${ab.num }</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${ab.title }</td>
	</tr>
	<tr>
		<td>가수</td>
		<td>${ab.singer }</td>
	</tr>
	<tr>
		<td>가격</td>
		<td>${ab.price }</td>
	</tr>
	<tr>
		<td>발매일</td>
		<td>${ab.day }</td>
	</tr>
</table>
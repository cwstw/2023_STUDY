<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- movieDetailView.jsp -->
<center>
<h2>영화 상세 화면</h2>
<table border="1" align="center">
	<tr>
		<td width="100">번호</td>
		<td width="200">${mv.num }</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${mv.title }</td>
	</tr>
	<tr>
		<td>국가</td>
		<td>${mv.nation }</td>
	</tr>
	<tr>
		<td>장르</td>
		<td>${mv.genre }</td>
	</tr>
	<tr>
		<td>등급</td>
		<td>${mv.grade }</td>
	</tr>
	<tr>
		<td>배우</td>
		<td>${mv.actor }</td> 
	</tr>
	<tr>
		<td colspan="2"><a href="list.tv?pageNumber=${param.pageNumber}">목록보기</a></td>
	</tr>
</table>
</center>
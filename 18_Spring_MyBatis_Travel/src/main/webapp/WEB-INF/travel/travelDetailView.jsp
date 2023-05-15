<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
travelDetailView.jsp<br>

<center>
<table border="1" align="center">
	<tr>
		<td width="100">이름</td>
		<td width="200">${tb.name }</td>
	</tr>
	<tr>
		<td>나이</td>
		<td>${tb.age }</td>
	</tr>
	<tr>
		<td>관심지역</td>
		<td>${tb.area }</td>
	</tr>
	<tr>
		<td>여행타입</td>
		<td>${tb.style }</td>
	</tr>
	<tr>
		<td>가격</td>
		<td>${tb.price }</td> 
	</tr>
	<tr>
		<td colspan="2"><a href="list.tv">목록보기</a></td>
	</tr>
</table>
</center>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
updateForm.jsp<br>
<%
	String[] winarr = {"한국","미국","독일","스페인"};
	String[] round16arr ={"한국","독일","브라질","잉글랜드","이탈리아","네덜란드","이란"};
%>
<style>
.err{
	color:red;
	font-weight:bold;
}
</style>
<from:form commandName="fdto" action="update" method="post">
<input type="hidden" namd="num" value="${fdto.num }">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="${fdto.id}"><form:errors cssClass="err" path="id"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="pw" value="${fdto.pw}"><form:errors cssClass="err" path="pw"></td>
		</tr>
		<tr>
			<td>우승예상국가</td>
			<td>
<%-- 				<input type="radio" name="win" value="한국" <c:if test="${fdto.win eq '한국'}">checked</c:if>>한국
				<input type="radio" name="win" value="미국" <c:if test="${fdto.win eq '미국'}">checked</c:if>>미국
				<input type="radio" name="win" value="독일" <c:if test="${fdto.win eq '독일'}">checked</c:if>>독일
				<input type="radio" name="win" value="스페인" <c:if test="${fdto.win eq '스페인'}">checked</c:if>>스페인
				<form:errors cssClass="err" path="win"> --%>
				<c:forEach var="w" items="<%=winarr %>">
					<input type="text" name="win" value="${w}">${w}
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td>16강 예상국가</td>
			<td>
<%-- 				<input type="checkbox" name="round16" value="한국" <c:if test="${fdto.round16.contains('한국')}">checked</c:if>>한국
				<input type="checkbox" name="round16" value="독일" <c:if test="${fdto.round16.contains('독일')}">checked</c:if>>독일
				<input type="checkbox" name="round16" value="브라질" <c:if test="${fdto.round16.contains('브라질')}">checked</c:if>>브라질
				<input type="checkbox" name="round16" value="잉글랜드" <c:if test="${fdto.round16.contains('일글랜드')}">checked</c:if>>잉글랜드
				<input type="checkbox" name="round16" value="이탈리아" <c:if test="${fdto.round16.contains('이탈리아')}">checked</c:if>>이탈리아
				<input type="checkbox" name="round16" value="네덜란드" <c:if test="${fdto.round16.contains('네덜란드')}">checked</c:if>>네덜란드
				<input type="checkbox" name="round16" value="이란" <c:if test="${fdto.round16.contains('이란')}">checked</c:if>>이란
				<form:errors cssClass="err" path="round16"> --%>
				<c:forEach var="r" items="<%=round16arr %>">
					<input type="text" name="win" value="${r}">${r}
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit">
			</td>
		</tr>
	</table>
</form:form>
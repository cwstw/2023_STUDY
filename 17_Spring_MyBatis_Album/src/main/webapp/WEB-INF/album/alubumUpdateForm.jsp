<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!-- label의 for는 input의 id와 연결 -->
alubumUpdateForm.jsp<br>
<style>
.err{
	font-weight:bold;
	color: red;
}
</style>
<form:form commandName="album" action="update.ab" method="post">
		<input type="hidden" name="num" value="${album.num}">
	<p>
		<label for="title">노래제목 :</label>
		<input type="text" name="title" id="title" value="${album.title}">
		<form:errors cssClass="err" path="title"/>
	</p>
	<p>
		<label for="singer">가수명 :</label>
		<input type="text" name="singer" id="singer" value="${album.singer}">
		<form:errors cssClass="err" path="singer"/>
	</p>
	<p>
		<label for="price">가격 :</label>
		<input type="text" name="price" id="price" value="${album.price}">
		<form:errors cssClass="err" path="price"/>
	</p>
	<p>
		<label for="day">발매일 :</label>
		<fmt:parseDate var="newDay" value="${album.day }" pattern="yyyy-MM-dd"/>
		<fmt:formatDate var="fNewDay" value="${newDay}" pattern="yyyy-MM-dd"/>
		<input type="text" name="day" id="day" value="${fNewDay }">
		<form:errors cssClass="err" path="day"/>
	</p>
	<p>
		<input type="submit" value="수정하기">
	</p>
</form:form>
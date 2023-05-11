<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!-- label의 for는 input의 id와 연결 -->
alubumInsertForm.jsp<br>
<style>
.err{
	font-weight:bold;
	color: red;
}
</style>
<form:form commandName="album" action="insert.ab" method="post">
	<p>
		<label for="title">노래제목 :</label>
		<input type="text" name="title" id="title">
		<form:errors cssClass="err" path="title"/>
	</p>
	<p>
		<label for="singer">가수명 :</label>
		<input type="text" name="singer" id="singer">
		<form:errors cssClass="err" path="singer"/>
	</p>
	<p>
		<label for="price">가격 :</label>
		<input type="text" name="price" id="price">
		<form:errors cssClass="err" path="price"/>
	</p>
	<p>
		<label for="day">발매일 :</label>
		<input type="text" name="day" id="day">
		<form:errors cssClass="err" path="day"/>
	</p>
	<p>
		<input type="submit" value="추가하기">
	</p>
</form:form>
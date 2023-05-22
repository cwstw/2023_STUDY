<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>

<!-- memberRegisterForm.jsp -->

<form:form method="post" action="register.mb">
	아이디 <input type="text" name="id" value="${mb.id}">
	<form:errors cssClass="err" path="id"/><br>
	이름 <input type="text" name="name" value="${mb.name}">
	<form:errors cssClass="err" path="name"/><br>
	비번 <input type="text" name="password" value="${mb.password}">
	<form:errors cssClass="err" path="password"/><br>
	성별 
	<input type="radio" name="gender" value="남자" <c:if test="${mb.gender.equals("남자")}">checked</c:if>>남자
	<input type="radio" name="gender" value="여자" <c:if test="${mb.gender.equals("여자")}">checked</c:if>>여자
	<form:errors cssClass="err" path="gender"/><br>
	취미 
	<input type="checkbox" name="hobby" value="마라톤" <c:if test="${mb.hobby.equals("마라톤")}">checked</c:if>>마라톤
	<input type="checkbox" name="hobby" value="영화감상" <c:if test="${mb.hobby.equals("영화감상")}">checked</c:if>>영화감상
	<input type="checkbox" name="hobby" value="게임" <c:if test="${mb.hobby.equals("게임")}">checked</c:if>>게임
	<input type="checkbox" name="hobby" value="공부" <c:if test="${mb.hobby.equals("공부")}">checked</c:if>>공부
	<form:errors cssClass="err" path="hobby"/><br>
	주소1 <input type="text" name="address1" value="${mb.address1}">
	<form:errors cssClass="err" path="address1"/><br>
	주소2 <input type="text" name="address2" value="${mb.address2}">
	<form:errors cssClass="err" path="address2"/><br>
	<input type="submit" value="추가하기">
</form:form>
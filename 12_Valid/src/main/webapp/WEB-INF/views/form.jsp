<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<style>
	.err{
	font-size: 9pt;
	color:red;
	font-weight: bold;
	}
</style>
form.jsp<br>
<form:form commandName="memberBean" action="form" method="post">
<!-- form 태그의 메서드는 지정해주지 않으면 default가 post(원래는 get) -->
	아이디 : <input type="text" name="id">
	<form:errors cssClass="err" path="id"/>
	<br>
	비밀번호 : <input type="text" name="passwd">
	<form:errors cssClass="err" path="passwd"/>
	<br>
	
	<input type="submit" value="전송"
></form:form>
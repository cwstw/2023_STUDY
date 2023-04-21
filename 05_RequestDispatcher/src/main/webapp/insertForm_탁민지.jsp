<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 서블릿=>result_내이름=>파람, 속성 출력 -->
insertForm.jsp => result_내이름.jsp<br>

<%
	String[] hobby = {"달리기","수영","등산","영화"};
%>
<c:set var="hobby" value="<%=hobby%>"/>
<h2>회원가입</h2>
<form name="myform" action="score" method="post">
	<span>아이디:</span> 
	<input type="text" name="id">&nbsp;
	<p>
	
	<span>비밀번호:</span> 
	<input type="password" name="passwd"><p>
	
	<span>이름:</span> 
	<input type="text" name="name"><p>
	<span>생년월일:</span>
		<select name="year">
			<c:forEach var="i" begin="0" end="${2023-1900}" step="1" >
				<c:set var="yearOption" value="${2023-i}" />
				<option value="${yearOption}">${yearOption}</option> 
			</c:forEach>
		</select>년&nbsp;
		<select name="month" id="month">
			<c:forEach var="i" begin="1" end="12" step="1">
				<option value="${i}">${i}</option> 
			</c:forEach>
		</select>월&nbsp;
		<select name="day" id="day">
			<c:forEach var="i" begin="1" end="31" step="1">
				<option value="${i}">${i}</option> 
			</c:forEach>
		</select>일
		<p>
	<span>취미: </span>
			<c:forEach var="i" begin="0" end="${fn:length(hobby)-1}" step="1">
				<input type="checkbox" name="hobby" value="${hobby[i]}">${hobby[i]}
			</c:forEach>
	<br><br>
	[성적 입력]<br>
	<span>C언어: </span><input type="text" name="c" style="width: 70px">&nbsp;
	<span>JAVA: </span><input type="text" name="java" style="width: 70px">&nbsp;
	<span>JSP: </span><input type="text" name="jsp" style="width: 70px"> 
	<p>
	<input type="submit" value="가입하기" id="sub" onClick=""> 
</form>

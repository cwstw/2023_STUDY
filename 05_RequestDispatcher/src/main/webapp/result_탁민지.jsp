<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result_탁민지.jsp<br>

[파라미터]<br>
아이디 : ${param.id}<br>
비밀번호 : ${param.passwd}<br>
이름 : ${param.name}<br>
생년월일 : ${param.year}-${param.month}-${param.day}<br>
취미 : ${paramValues.hobby}<br>
c언어 : ${param.c}<br>
자바 : ${param.java}<br>
jsp : ${param.jsp}<br>
<br>
[속성]<br>
아이디 : ${requestScope.aid}<br>
비밀번호 : ${requestScope.apasswd}<br>
이름 : ${requestScope.aname}<br>
생년월일 : ${requestScope.ayear}-${requestScope.amonth}-${requestScope.aday}<br>
취미 : ${requestScope.ahobby}<br>
c언어 : ${requestScope.ac}<br>
자바 : ${requestScope.ajava}<br>
jsp : ${requestScope.ajsp}<br>

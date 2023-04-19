<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

Ex05_result.jsp<br>
<%

%>
국어 : ${param.kor}<br>
영어 : ${param.eng}<br>
수학 : ${param.mat}<br>

<c:set var="k" value="${param.kor}"/>
<c:set var="e" value="${param.eng}"/>
<c:set var="m" value="${param.mat}"/>
<c:out value="${k}"/>
${k}
<c:out value="${param.kor}"/><br><br>
<c:set var="sum" value="${param.mat+param.eng+param.mat}"/>
<c:set var="sum1" value="${param.mat}+${param.eng}+${param.mat}"/>
<c:set var="sum2" value="${k+e+m}"/>

합계1 : ${k}+${e}+${m}=${k+e+m}<br>
합계2 : ${sum1}
합계3 : ${sum2}
합계3 : ${sum1}

<c:if test="${sum1>=90 }">
	A학점
</c:if>
<c:if test="${sum>=80 and sum<90 }">
	B학점
</c:if>
<c:if test="${sum>=70 and sum<80 }">
	C학점
</c:if>
<c:if test="${sum>=60 && sum<70 }">
	D학점
</c:if>
<c:if test="${sum<60 }">
	F학점
</c:if>





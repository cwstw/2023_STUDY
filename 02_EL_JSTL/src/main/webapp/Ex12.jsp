<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
Ex12.jsp<br>

<c:set var="str" value="가나/다라*마바/사/아"/>
\${str} : ${str}<br>

<c:forTokens var="one" items="${str}" delims="/*" varStatus="st">
	${st.index+1} : ${one}<br>
</c:forTokens>
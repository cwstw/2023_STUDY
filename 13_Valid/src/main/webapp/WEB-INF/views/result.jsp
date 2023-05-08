<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/funtions" %>
result.jsp<br>

제목 : ${param.title}
저자 : ${param.author}
가격 : ${param.price }
출판사 : ${param.publisher }
구입가능서점 :
<c:forEach var="bs" items="${paramValues.bookstore}"  varStatus="st">
	${bs}
	<c:if test="${not st.last}">,</c:if>
</c:forEach>
배송비 : ${param.kind}
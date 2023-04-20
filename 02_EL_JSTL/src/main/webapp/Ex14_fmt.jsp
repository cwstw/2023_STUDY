<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
Ex14_fmt.jsp<br>
<c:set var="price" value="12345"/>
\${price} : ${price}<br>
\${price} : <c:out value="${price}"/>
<br><br>
통화 : <fmt:formatNumber value="${price}" type="currency" currencySymbol="원"/><br>
퍼센트 : <fmt:formatNumber value="${price}" type="percent" groupingUsed="true"/><br>
패턴1 : <fmt:formatNumber value="${price}" pattern="000,000.00"/><br>
패턴2 : <fmt:formatNumber value="${price}" pattern="###,###.00"/><br>
패턴3 : <fmt:formatNumber var="su1" value="123.56789" maxFractionDigits="1"/><br>
\${su1} : ${su1}<br>

패턴4 : <fmt:parseNumber var="su1" value="123.56789" integerOnly="true"/><br>






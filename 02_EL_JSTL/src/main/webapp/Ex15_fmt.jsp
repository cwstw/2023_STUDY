<%@page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
Ex15_fmt.jsp<br>

<c:set var="now" value="<%=new Date() %>"/>
now1 : ${now}<br>
now2 : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full"/><br>
now3 : <fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="medium"/><br>
now4 : <fmt:formatDate value="${now}" type="date" dateStyle="medium" timeStyle="medium"/><br>
now5 : <fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium" pattern="yyyy-MM-dd hh:mm:ss"/><br>
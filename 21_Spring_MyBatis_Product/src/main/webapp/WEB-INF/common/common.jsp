<%@page import="member.model.MemberBean"%>
<%@page import="java.net.http.HttpResponse"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- common.jsp -->

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


접속자 아이디1 : <%=session.getAttribute("loginInfo")%>
<%
MemberBean mb = (MemberBean)session.getAttribute("loginInfo");
if(mb!=null){
	out.println("접속자 아이디2: "+mb.getId());
}
%>
접속자 아이디2 : <%=mb.getId() %>
접속자 아이디3 : ${sessionScope.loginInfo.id}
접속자 아이디4 : ${loginInfo.id}
접속자 비밀번호 : ${loginInfo.password}
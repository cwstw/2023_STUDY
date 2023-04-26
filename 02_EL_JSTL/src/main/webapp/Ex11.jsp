<%@page import="myPkg.BookServlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
Ex11.jsp<br>
[자바객체]<br>
<%
p

	BookServlet bk1 = new BookServlet("EL","웬디",2000);
	out.println("bk1.getTitle():"+bk1.getTitle());
	out.println("bk1:"+bk1+"<br>");
	out.println("bk1:"+bk1.toString()+"<br>");
%>
<c:set var="bk1" value="<%=t(bk%>"/>
\${bk1.title } : ${bk1.title}<br>
\${bk1} : ${bk1}<Br>
<br>
[jsp 객체]<br>
<jsp:useBean id="b" class="w"/>
<jsp:setProperty property="title" name="bkb" value="EL"/>
<jsp:setProperty property="author" name="bkb" value="웬디"/>
<jsp:setProperty property="price" name="bkb" value="2000"/>

\${bkb.title } : ${bkb.title}<br>
\${bkb} : ${bkb}<br>
<br>
<hr>
[JSTL 객체]<BR>
<c:set var="bk3" value='<%=t(new myPkg.BookServlet(%>'/>
<c:set target="${bk3}" property="title" value="EL"/>
<c:set target="${bk3}" property="author" value="웬디"/>
<c:set target="${bk3}" property="price" value="2000"/>

\${bk3.title } : ${bk3.title}<br>
\${bk3} : ${bk3}<Br>






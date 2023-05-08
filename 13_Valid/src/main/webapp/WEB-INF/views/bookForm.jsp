<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
bookForm.jsp<br>
<style>
.err{
	font-weight: bold;
	color: red;
}
</style>
<form:form action="form" method="post">
	제목 : <inptut type="text" name="title" value="${bookBean.title }">
	<form:errors cssClass="err" path="title"><br>
	
	저자 : <inptut type="text" name="author" value="${bookBean.author }">
	<form:errors cssClass="err" path="author"><br>
	
	가격 : <inptut type="text" name="price" value="${bookBean.price }">
	<form:errors cssClass="err" path="price"><br>
	
	출판사 : <inptut type="text" name="publisher" value="${bookBean.publisher }">
	<form:errors cssClass="err" path="publisher"><br>
	
	구입가능서점 :
	<input type="checkbox" name="bookstore" value="교보문고" <%if(${bookBean.bookstore}.contains("교보문고")){ %>checked<%} %>>교보문고
	<input type="checkbox" name="bookstore" value="알라딘" <%if(${bookBean.bookstore}.contains("알라딘")){ %>checked<%} %>>알라딘
	<input type="checkbox" name="bookstore" value="yes24" <%if(${bookBean.bookstore}.contains("yes24")){ %>checked<%} %>>yes24
	<input type="checkbox" name="bookstore" value="영풍문고" <%if(${bookBean.bookstore}.contains("영풍문고")){ %>checked<%} %>>영풍문고<br>
	배송비 : 
	<input type="radio" name="kind" value="유료" <%if(${bookBean.kind}.equals("유료")){ %>checked<%} %>>유료
	<input type="radio" name="kind" value="무료" <%if(${bookBean.kind}.equals("무료")){ %>checked<%} %>>무료<br><br>
	
	<input type="submit" value="전송"><br>
</form:form>
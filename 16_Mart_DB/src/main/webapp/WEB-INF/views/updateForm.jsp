<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
updateForm.jsp <br>

<h2> 이마트 상품 구매 내역 </h2>
<FORM name="myform" METHOD="post" ACTION="form">
<input type="hidden" name="num" value="${mDto.num }">
 <span>아이디 :</span> <INPUT TYPE="text" NAME="id" vlaue="${mDto.id}"><br>
 <span>비번 :</span> <INPUT TYPE="text" NAME="pw" vlaue="${mDto.pw}"><br>
  <p> 
 
 
<span>구매상품:</span>
	<input type="checkbox" name="product" value="식품" <c:if test="${mDto.product.contains("식품")}">checked</c:if>>식품
	<input type="checkbox" name="product" value="의류" <c:if test="${mDto.product.contains("의류")}">checked</c:if>>의류
	<input type="checkbox" name="product" value="도서" <c:if test="${mDto.product.contains("도서")}">checked</c:if>>도서
	<input type="checkbox" name="product" value="가구" <c:if test="${mDto.product.contains("가구")}">checked</c:if>>가구
<p>

<span>배송시간 :</span> 
 	<SELECT NAME="time" <c:if test="${mDto.time.equals("선택")}">value="0"</c:if>>
 		<OPTION VALUE="선택">선택</OPTION>
		<OPTION VALUE="9시~11시">9시~11시</OPTION>
		<OPTION VALUE="11시~1시">11시~1시</OPTION>
		<OPTION VALUE="1시~5시">1시~5시</OPTION>
		<OPTION VALUE="5시~9시">5시~9시</OPTION>
	</SELECT>
<p>

<span>결제방법:</span>
카드 <INPUT TYPE="radio" NAME="approve" VALUE="카드" <c:if test="${mDto.approve.equals("카드")}">checked</c:if>>
핸드폰 <INPUT TYPE="radio" NAME="approve" VALUE="핸드폰" <c:if test="${mDto.approve.equals("핸드폰")}">checked</c:if>>
<p>
<span>결제 동의합니다. </span>  
<INPUT TYPE="checkbox" NAME="agree" id="agree" <c:if test="${mDto.approve.contains("agree")}">checked</c:if>> 
<p>

<INPUT TYPE="submit" value="수정">
</FORM>




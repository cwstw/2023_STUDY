<%@page import="myPkg.MovieDao"%>
<%@page import="myPkg.MovieBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
updateForm.jsp <br>
<!-- 
2가지 경우
목록보기(select.jsp)에서 수정클릭 => updateForm.jsp 
수정하기에서 실패(updateProc.jsp) => updateForm.jsp 
100 => 10000
90 => 9000
50 => 5000 -->

<%
	String[] time = {"08~10","10~12","12~14","14~16","16~18","18~20"};
	String[] genreArr = {"공포", "코미디", "액션", "애니메이션"};
	String[] partner = {"1","2","3","4","5"};
	String num = request.getParameter("num");
	
%>
<%-- <jsp:useBean id="mdao" class="myPkg.MovieDao"/> --%>

<form name="myform" action="update.mv" method="post">
	<input type="hidden" name="num" value="${mb.num }">
	<table border="1">
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" name="id" value="${mb.id }">
			<input type="button" id="idCheck" value="중복체크">
			<span id="idmessage"></span>
		</td>
	</tr>
	<tr>
		<td>이름</td>
		<td>
			<input type="text" name="name" value="${mb.name }">
		</td>
	</tr>
	<tr>
		<td>나이</td>
		<td>
			<input type="text" name="age" value="${mb.age }">
		</td>
	</tr>
	<tr>
		<td>좋아하는 장르</td>
		<td>
			<c:forEach var="g" items="<%=genreArr%>" varStatus="status">
		<input type="checkbox" name = "genre" value="${ g }" <c:if test="${ fn:contains(requestScope.mb.genre,g) }"> checked </c:if>>${ g }
		<c:if test="${ status.index == 2 }"><br></c:if>
			</c:forEach>
		</td>
	</tr>
	
	<tr>
		<td>즐겨보는 시간대</td>
		<td>
			<select name="time">
				<c:set var="time" value="<%=time %>"/>
				<c:forEach var="tiem" items="${time }">
					<option value="${time }" <c:if test="${mb.time==time }">selected</c:if>>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>동반 관객수</td>
		<td>
		<c:set var="partner" value="<%=partner%>"/>
		<c:forEach var="i" begin="0" end="${fn:length(partner)-1}">
			<input type="radio" name="partner" value="${partner[i]}" <c:if test="${mb.partner==partner[i]}">checked</c:if>>${partner[i]}
		</c:forEach>
	</td>
	</tr>
	<tr>
		<td>영화관 개선사항</td>
		<td>
			<textarea rows="4" cols="40" name="memo"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" id="sub" value="수정하기" onClick="return check()"></td>
		
	</tr>
	
	
</table>	
</form>





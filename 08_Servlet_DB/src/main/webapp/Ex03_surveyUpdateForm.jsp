<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
Ex03_surveyUpdateForm.jsp<br>
<%
 String[] satisfaction = {"매우만족", "만족", "보통", "불만족", "매우불만족"};
 String[] partArr = {"JAVA", "Spring", "UML", "JDBC", "서블릿" ,"JSP"};
%>
<form action="update.sv" method="post"> 
<input type="hidden" name="no" value="${sb.no}">
	 과정 만족도 설문<br>
	 아래 항목을 입력해 주세요.<P>
	
	 <b>개인 정보 :</b><br>
	이름 　　　　<input type="text" name="name" value="${sb.name}"><br>
	소속 회사　　<input type="text" name="company" value="${sb.company}"><br>
	이메일 주소　<input type="text" name="email" value="${sb.email}"><br>
	<p>
	<b>본 교육 과정을 수강하고 과정에 만족도를 선택해 주세요.</b><br>
	<%-- 
	<input type="radio" name = "satisfaction" value="매우만족" <c:if test="${sb.satisfaction=='매우만족'}">checked</c:if> >매우 만족 
	<input type="radio" name = "satisfaction" value="만족" ${sb.getSatisfaction() eq "만족" ? "checked":"" }>만족
	<input type="radio" name = "satisfaction" value="보통">보통
	<input type="radio" name = "satisfaction" value="불만족">불만족
	<input type="radio" name = "satisfaction" value="매우불만족">매우불만족
	 --%>
	 
	<c:set var="satisfaction" value="<%=satisfaction %>"/>
	<c:forEach var="i" begin="0" end="${fn:length(satisfaction)-1}">
		<input type="radio" name="satisfaction" value="${satisfaction[i]}" <c:if test="${sb.satisfaction==satisfaction[i]}">checked</c:if>>${satisfaction[i]}
	</c:forEach>
	<p>
	<b>관심있는 분야는 무엇입니까?</b><br>
	<!-- 
	<input type="checkbox" name = "part" value="JAVA">JAVA
	<input type="checkbox" name = "part" value="Spring">Spring
	<input type="checkbox" name = "part" value="UML" checked="checked">UML<br>
	<input type="checkbox" name = "part" value="JDBC">JDBC
	<input type="checkbox" name = "part" value="서블릿">서블릿
	<input type="checkbox" name = "part" value="JSP" checked="checked">JSP<br>
	 -->
	 
	 <%-- <c:set var="partArr" value="<%=partArr %>"/> --%>
	<c:forEach var="p" items="<%=partArr%>" varStatus="status">
		<input type="checkbox" name = "part" value="${ p }" <c:if test="${ fn:contains(requestScope.sb.part,p) }"> checked </c:if>>${ p }
		<c:if test="${ status.index == 2 }"><br></c:if>
	</c:forEach>
	
	<p>
	정보 발송 방법 <select name="howto">
		<option value="email" <c:if test = "${sb.howto == 'email' }"> selected </c:if>>email
		<option value="우편" <c:if test = "${sb.howto == '우편' }"> selected </c:if>>우편
		</select>
	
	<p>
	<input type="checkbox" name="agree" value="1" <c:if test="${sb.agree == 1 }">checked</c:if>> 정보 발송에 동의합니다.<br>
	<input type="submit" value="수정하기">
</form>








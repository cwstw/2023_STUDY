<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
Ex03_surveyList.jsp<br>


<table border="1">
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>소속회사</td>
		<td>이메일</td>
		<td>과정 만족도</td>
		<td>관심분야</td>
		<td>정보발송방법</td>
		<td>정보발송동의</td>
		<td>삭제</td>
		<td>수정</td>
	</tr>
	<c:forEach var="sb" items="${requestScope.slists }">
		<tr>
			<td>${sb.no }</td>
			<td>${sb.getName() }</td>
			<td>${sb['company'] }</td>
			<td>${sb["email"] }</td>
			<td>${sb.satisfaction }</td>
			<td>${sb.part }</td>
			<td>${sb.howto }</td>
			<c:if test="${sb.getAgree()==0 }">
				<td>동의안함</td>
			</c:if>
			<c:if test="${sb.getAgree()!=0 }">
				<td>동의함</td>
			</c:if>
			<td><a href="delete.sv?no=${sb.no }">삭제</a></td>
			<td><a href="updateForm.sv?no=${sb.no }">수정</a></td>
		</tr>
	</c:forEach>
</table>	
<br><br>

<a href="Ex03_surveyInsertForm.jsp">등록</a>





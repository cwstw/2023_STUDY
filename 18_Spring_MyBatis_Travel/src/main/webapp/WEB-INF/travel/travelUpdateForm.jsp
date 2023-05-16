<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>   
 <style type="text/css">
	.err{
		color:red;
		font-weight: bold;
		font-size: 9px;
	}
</style>
<%
	String[] areaArr = { "유럽","동남아","일본","중국" };

	String[] styleArr = { "패키지","크루즈","자유여행","골프여행" };
	
	String[] priceArr = { "100~200","200~300","300~400","400~500" };
	
%>
travelUpdateForm.jsp<br>
<h2>여행 정보 수정 화면</h2>
<form:form commandName="travel" method="post" action="update.tv">

	<input type="hidden" name="pageNumber" value="${pageNumber }">
	<input type="hidden" name="num" value="${tb.num }">
	<p>
		<label>이름</label>
		<input type="text" name="name" value="${tb.name }">
		<form:errors cssClass="err" path="name"/>
	</p>

	<p>
		<label>나이</label>
		<input type="text" name="age" value="${tb.age }">
		<form:errors cssClass="err" path="age"/>
	</p>
	
	<p>
		<label>관심지역</label>
		<!-- <input type="checkbox" name="area" value="유럽">유럽
		<input type="checkbox" name="area" value="동남아">동남아
		<input type="checkbox" name="area" value="일본">일본
		<input type="checkbox" name="area" value="중국">중국 -->
		<c:forEach var="ar" items="<%=areaArr%>">
			<input type="checkbox" name="area" value="${ar}" <c:if test="${fn:contains(tb.area, ar)}">checked</c:if>>${ar}
		</c:forEach>
		<form:errors cssClass="err" path="area"/>
	</p>
	
	<p>
		<label>여행타입</label>
		<!-- <input type="radio" name="style" value="패키지">패키지
		<input type="radio" name="style" value="크루즈">크루즈
		<input type="radio" name="style" value="자유여행">자유여행
		<input type="radio" name="style" value="골프여행">골프여행 -->
		<c:forEach var="s" items="<%=styleArr%>">
			<input type="radio" name="style" value="${s}"<c:if test="${tb.style == s}">checked</c:if>>${s}
		</c:forEach>
		
		<form:errors cssClass="err" path="style"/>
	</p>
	
	<p>
		<label>가격</label>
		<select name="price">
			<option value="">선택하세요</option>
			<!-- <option value="100~200">100~200</option>
			<option value="200~300">200~300</option>
			<option value="300~400">300~400</option>
			<option value="400~500">400~500</option> -->
			<c:forEach var="p" items="<%=priceArr%>">
				<option value="${p}"
					<c:if test="${tb.price == p}">selected</c:if>>${p}</option>
			</c:forEach>
		</select>
		<form:errors cssClass="err" path="price"/>
	</p>
	<p>
		<input type="submit" value="수정하기">
	</p>
</form:form>

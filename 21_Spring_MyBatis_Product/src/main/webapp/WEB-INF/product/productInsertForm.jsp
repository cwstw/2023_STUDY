<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>

<!-- file 업로드 시 post/enctype속성 -->
<!-- ServletCOntext 객체는 원래 자동 생성(프로젝트 당 하나)  -->
<style type="text/css">
	.err{
		color:red;
		font-size: 9pt;
	}	
</style>
<h2>상품 추가 화면</h2>
<form:form commandName="" action="insert.prod" method="post" enctype="multipart/form-data">
	<p>
		*상품명 : 
		<input type="text" name="name">
		<form:errors cssClass="err" path="name"/>
	</p>
	<p>
		제조회사 : 
		<input type="text" name="company">
	</p>
	<p>
		*가격 : 
		<input type="text" name="price">
		<form:errors cssClass="err" path="price"/>
	</p>
	<p>
		재고수량 : 
		<input type="text" name="stock">
	</p>
	<p>
		적립포인트 : 
		<input type="text" name="point">
	</p>
	<p>
		*설명 : 
		<input type="text" name="contents">
		<form:errors cssClass="err" path="contents"/>
	</p>
	<p>
		*상품 이미지 : 
		<input type="file" name="upload">
		<form:errors cssClass="err" path="image"/>
		<!-- 파일은 string에 넣을 수 없음,
		이름을 bean에 없는 이름으로 설정 -->
	</p>
	<p>
		입고 일자 : 
		<input type="date" name="inputdate">
	</p>
	 <p>
 	<input type="submit" value="추가하기">
	</p>
</form:form>
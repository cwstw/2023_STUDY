<%@page import="ARTSHOP.PRODUCT.CATEGORYDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ARTSHOP.PRODUCT.CATEGORYDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- PR_PRODUCTINPUT.jsp -->
<%
	request.setCharacterEncoding("utf-8");
	CATEGORYDAO cdao = CATEGORYDAO.getInstance();
	ArrayList<CATEGORYDTO> lists = cdao.getAllCategory();
%>
<style>
body{
 background-image: url(../IMAGES/ARTSHOP_MAIN_IMAGE02.jpg);
 background-size: cover;
}
</style>
<jsp:include page="PR_TOP.jsp"/>
<div class="mx-auto shadow-sm p-3 mb-5 bg-body rounded" style="width: 600px; margin-top:50px;">
  	<h2>상품등록</h2>
  	<hr>
<form method="post" name="registerform" action="REGISTER_PROC.jsp" enctype="multipart/form-data">
	<label for="exampleInputId" class="form-label">샘플 사진 :</label>
	<div class="mb-3">
  		<input class="form-control form-control-sm w-50" type="file" name="samimg" id="inputimage" accept="image/*" multiple>
	</div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">상품이름 :</label>
    <div class="input-group w-50">
  		<input type="text" class="form-control" placeholder="Product" name="prosub">
	</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">판매자 :</label>
    <div class="input-group w-50">
  		<input type="text" class="form-control" placeholder="Producer" name="prowri">
	</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">카테고리 :</label>
    <div class="input-group w-75">
  		<select>
  			<%
  			if(lists.size() == 0){
				%>
					<option value=""> 카테고리 없음</option>
				<%
				} else{
  				for(int i=0;i<=lists.size();i++){ %>
  					<option value="<%=i%>"></option>
  			<%}
  			}%>
  		</select>
	</div>
	<small class="text-muted" id="pwrule">영문 소문자/숫자 조합 3~8자</small>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">비밀번호 확인 :</label>
    <div class="input-group w-75">
  		<input type="text" class="form-control" placeholder="Password" name="mempw2" onKeyUp="pw2check()">
	</div>
	<small class="text-muted" id="pwmessage"></small>
  </div>
    <div class="mb-3">
    	<label for="exampleInputPassword1" class="form-label">이름 :</label>
    	<div class="input-group w-25">
  			<input type="text" class="form-control" placeholder="Name" name="memname">
		</div>
  	</div>
  	<div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">주민등록번호 :</label>
	    <div class="row">
	  		<div class="col-4">
	    		<input type="text" class="form-control" name="memrrn1" aria-label="rrn1" maxlength="6">
	  		</div>
	  		- 
	 		<div class="col-4">
	    		<input type="text" class="form-control" name="memrrn2" aria-label="rrn2" maxlength="7">
	 		</div>
		</div>
  	</div>
	<label for="exampleInputPassword1" class="form-label">회원 종류 :&nbsp;</label><br>
	<div class="form-check form-check-inline mb-3">
		<label class="form-check-label" for="inlineRadio1">
		<input class="form-check-input" type="radio" name="memkind" id="inlineRadio1" value="작가">
		작가회원</label>
	</div>
	<div class="form-check form-check-inline">
		<label class="form-check-label" for="inlineRadio2">
		<input class="form-check-input" type="radio" name="memkind" id="inlineRadio2" value="일반">
		일반회원</label>
	</div>
	<div class="mb-3">
  	<label for="exampleFormControlTextarea1" class="form-label">자기소개 : </label>
  	<textarea class="form-control" id="exampleFormControlTextarea1" name="mempr" rows="3"></textarea>
</div>
  	<button type="submit" class="btn btn-primary" onClick="return writeSave()">가입하기</button>
</form>
</div>
<jsp:include page="../../ARTSHOP_MAIN_BOTTOM.jsp"/>
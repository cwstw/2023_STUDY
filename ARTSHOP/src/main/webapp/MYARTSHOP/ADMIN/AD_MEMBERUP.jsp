<%@page import="ARTSHOP.MEMBER.MEMBERDTO"%>
<%@page import="ARTSHOP.MEMBER.MEMBERDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- AD_MEMBERUP.jsp -->
<%
	String memnum = request.getParameter("memnum");
	MEMBERDAO mdao = MEMBERDAO.getInstance();
	MEMBERDTO mdto = mdao.getMemberByMemnum(memnum); 
%>
<script>
	function readImage(input) {
	
	    // 인풋 태그에 파일이 있는 경우
	    if(input.files && input.files[0]) {
	
	        // 이미지 파일인지 검사 (생략)
	
	        // FileReader 인스턴스 생성
	        const reader = new FileReader()
	
	        // 이미지가 로드가 된 경우
	        reader.onload = e => {
	            const previewImage = document.getElementById("preview-image")
	            previewImage.src = e.target.result
	        }
	
	        // reader가 이미지 읽도록 하기
	        reader.readAsDataURL(input.files[0])
	    }
	}

</script>
<style>
body{
	background : #e9e9e9!important;
}
</style>
<jsp:include page="AD_TOP.jsp"/>
    <!-- Page Content-->
    <h1 class="mb-5 mt-5 text-center">회원 수정</h1>
    <div class="mx-auto shadow-sm p-3 mb-5 bg-body rounded" style="width: 600px; margin-top:50px;">
    <form method="post" name="registerform" action="AD_MEMBERUP_PROC.jsp?memnum=<%=memnum %>" enctype="multipart/form-data">
	<label for="exampleInputId" class="form-label">프로필 사진 :</label>
	<div class="mb-3">
  		<label for="formFileSm" class="form-label"><img src="http://placehold.it/150x150.png?text=IMAGE" width="150px" class="img-thumbnail" id="preview-image" alt="profilepic"></label>
  		<input class="form-control form-control-sm w-50" type="file" name="mempic" id="inputimage" accept="image/*" value="<%=mdto.getMempic() %>" onchange="readImage(this);">
	</div>
  	<div class="mb-3">
    	<label for="exampleInputId" class="form-label">아이디 :</label>
		<div class="input-group w-50">
  			<input type="text" class="form-control" placeholder="ID" name="memid" onkeydown="keyd()" value="<%=mdto.getMemid() %>">
  			<button class="btn btn-outline-secondary" type="button" id="button-addon2" onClick="duplicate()">중복체크</button>
		</div>
		<small class="text-muted" id="idmessage"></small>
	</div>
  	<div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">닉네임 :</label>
    <div class="input-group w-50">
  		<input type="text" class="form-control" name="memnick" value="<%=mdto.getMemnick() %>">
	</div>
  	</div>
  	<div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">비밀번호 :</label>
    <div class="input-group w-75">
  		<input type="text" class="form-control" placeholder="Password" name="mempw" onBlur="return pwcheck()" value="<%=mdto.getMempw() %>">
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
  			<input type="text" class="form-control" placeholder="Name" name="memname" value="<%=mdto.getMemname() %>">
		</div>
  	</div>
  	<div class="mb-3">
	    <label for="exampleInputPassword1" class="form-label">주민등록번호 :</label>
	    <div class="row">
	  		<div class="col-4">
	    		<input type="text" class="form-control" name="memrrn1" aria-label="rrn1" maxlength="6" value="<%=mdto.getMemrrn1() %>">
	  		</div>
	  		- 
	 		<div class="col-4">
	    		<input type="text" class="form-control" name="memrrn2" aria-label="rrn2" maxlength="7" value="<%=mdto.getMemrrn2() %>">
	 		</div>
		</div>
  	</div>
	<label for="exampleInputPassword1" class="form-label">회원 종류 :&nbsp;</label><br>
	<div class="form-check form-check-inline mb-3">
		<label class="form-check-label" for="inlineRadio1">
		<input class="form-check-input" type="radio" name="memkind" id="inlineRadio1" value="작가" <%if(mdto.getMemkind().equals("작가")){ %>checked<%} %>>
		작가회원</label>
	</div>
	<div class="form-check form-check-inline">
		<label class="form-check-label" for="inlineRadio2">
		<input class="form-check-input" type="radio" name="memkind" id="inlineRadio2" value="일반" <%if(mdto.getMemkind().equals("일반")){ %>checked<%} %>>
		일반회원</label>
	</div>
	<div class="mb-3">
  	<label for="exampleFormControlTextarea1" class="form-label">자기소개 : </label>
  	<textarea class="form-control" id="exampleFormControlTextarea1" name="mempr" rows="3"><%=mdto.getMempr() %></textarea>
	</div>
  	<button type="submit" class="btn btn-primary" onClick="return writeSave()">수정하기</button>
	</form>
    </div>
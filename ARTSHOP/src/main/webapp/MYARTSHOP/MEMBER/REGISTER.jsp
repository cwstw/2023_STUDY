<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- REGISTER.jsp -->
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="<%=request.getContextPath() %>/js/scripts.js"></script>
<script src="<%=request.getContextPath() %>/js/jquery.js"></script>
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
	
	// input file에 change 이벤트 부여
	const inputImage = document.getElementById("input-image")
	inputImage.addEventListener("change", e => {
	    readImage(e.target)
	})
</script>
<style>
body{
 background-image: url(../IMAGES/ARTSHOP_MAIN_IMAGE02.jpg);
}
</style>
<jsp:include page="../../ARTSHOP_MAIN_TOP.jsp"/>
<div class="mx-auto shadow-sm p-3 mb-5 bg-body rounded" style="width: 600px; margin-top:50px;">
  	<h2>회원가입</h2>
  	<small class="text-muted">환영해요! 아트#은 당신을 기다리고 있었어요🎉</small>
  	<hr>
<form method="post" name="registerform" action="REGISTER_PROC.jsp">
	<label for="exampleInputId" class="form-label">프로필 사진 :</label>
	<div class="mb-3">
  		<label for="formFileSm" class="form-label"><img src="http://placehold.it/150x150.png?text=IMAGE" width="150px" class="img-thumbnail" id="preview-image" alt="profilepic"></label>
  		<input class="form-control form-control-sm w-50" type="file" name="mempic" id="inputimage" accept="image/*" onchange="readImage(this);">
	</div>
  	<div class="mb-3">
    	<label for="exampleInputId" class="form-label">아이디 :</label>
		<div class="input-group w-50">
  			<input type="text" class="form-control" placeholder="ID" name="memid" aria-describedby="button-addon2">
  			<button class="btn btn-outline-secondary" type="button" id="button-addon2">중복체크</button>
		</div>
	</div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">닉네임 :</label>
    <div class="input-group w-50">
  		<input type="text" class="form-control" placeholder="Nickname" name="memnick">
	</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">비밀번호 :</label>
    <div class="input-group w-75">
  		<input type="text" class="form-control" placeholder="Password" name="mempw">
	</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">비밀번호 확인 :</label>
    <div class="input-group w-75">
  		<input type="text" class="form-control" placeholder="Password" name="mempw">
	</div>
  </div>
    <div class="mb-3">
    	<label for="exampleInputPassword1" class="form-label">이름 :</label>
    	<div class="input-group w-25">
  			<input type="text" class="form-control" placeholder="Name" name="mempw">
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
	<label for="exampleInputPassword1" class="form-label">회원 종류 :&nbsp;</label>
	<div class="form-check form-check-inline">
		<input class="form-check-input" type="radio" name="memkind" id="inlineRadio1" value="작가">
		<label class="form-check-label" for="inlineRadio1">작가회원</label>
	</div>
	<div class="form-check form-check-inline">
		<input class="form-check-input" type="radio" name="memkind" id="inlineRadio2" value="일반">
		<label class="form-check-label" for="inlineRadio2">일반회원</label>
	</div>
	<div class="mb-3">
  	<label for="exampleFormControlTextarea1" class="form-label">자기소개 : </label>
  	<textarea class="form-control" id="exampleFormControlTextarea1" name="mempr" rows="3"></textarea>
</div>
  	<button type="submit" class="btn btn-primary">로그인</button>
</form>
</div>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--LOGINHELPID.jsp -->
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
<style>
body{
 background-image: url(../IMAGES/ARTSHOP_MAIN_IMAGE02.jpg);
}
</style>
<jsp:include page="../../ARTSHOP_MAIN_TOP.jsp"/>
<div class="mx-auto shadow-sm p-3 mb-5 bg-body rounded" style="width: 500px; margin-top:50px;">
  	<h2>비밀번호 찾기</h2>
  	<hr>
<form method="post" name="findidform" action="FINDPW_PROC.jsp">
  <div class="mb-3">
    <label for="exampleInputId" class="form-label">아이디 :</label>
    <input type="text" class="form-control" name="memid">
  </div>
  <div class="mb-3">
    <label for="exampleInputId" class="form-label">이름 :</label>
    <input type="text" class="form-control" name="memname">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">주민등록번호 :</label>
    <div class="row">
  		<div class="col">
    		<input type="text" class="form-control" name="memrrn1" aria-label="rrn1" maxlength="6">
  		</div>
  		- 
 		<div class="col">
    		<input type="text" class="form-control" name="memrrn2" aria-label="rrn2" maxlength="7">
 		</div>
	</div>
  </div>
  <button type="submit" class="btn btn-primary">비밀번호 찾기</button>
</form>
</div>
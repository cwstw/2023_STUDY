<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
  	<h2>���̵� ã��</h2>
  	<hr>
<form method="post" name="findidform" action="FINDID_PROC.jsp">
  <div class="mb-3">
    <label for="exampleInputId" class="form-label">�̸� :</label>
    <input type="text" class="form-control" name="memname">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">�ֹε�Ϲ�ȣ :</label>
    <div class="row">
  		<div class="col">
    		<input type="text" class="form-control" name="memrrn1" aria-label="rrn1">
  		</div>
 		<div class="col">
    		<input type="text" class="form-control" name="memrrn2" aria-label="rrn2">
 		</div>
	</div>
  </div>
  <button type="submit" class="btn btn-primary">���̵� ã��</button>
</form>
</div>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!--LOGIN.jsp  -->
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
  	<h2>�α���</h2>
  	<hr>
<form method="post" name="loginform" action="LOGINPROC.jsp">
  <div class="mb-3">
    <label for="exampleInputId" class="form-label">���̵� :</label>
    <div class="form-floating mb-3">
  <input type="text" name="memid" class="form-control" id="floatingInput" placeholder="name@example.com">
  <label for="floatingInput">ID</label>
</div>
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">��й�ȣ :</label>
    <div class="form-floating">
  <input type="password" name="mempw" class="form-control" id="floatingPassword" placeholder="Password">
  <label for="floatingPassword">Password</label>
</div>
  </div>
  <div id="FIND" class="form-text" style="margin-bottom:8px;">
  	���̵�/��й�ȣ�� ��ﳪ�� �ʳ���?
  	<a class="text-decoration-none" href="FINDID.jsp">���̵� ã��</a> | 
  	<a class="text-decoration-none" href="FINDPW.jsp">��й�ȣ ã��</a>
  </div>
  <div id="REGISTER" class="form-text" style="margin-bottom:15px;">
  	���� ART# ������ �����Ű���?
  	<a class="text-decoration-none" href="REGISTER.jsp">ȸ������</a> 
  </div>
  <button type="submit" class="btn btn-primary">�α���</button>
</form>
</div>
<%@page import="ARTSHOP.PRODUCT.PRODUCTDTO"%>
<%@page import="ARTSHOP.PRODUCT.PRODUCTDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- GN_ORDER.jsp -->
<%
	request.setCharacterEncoding("utf-8");
	String pronum = request.getParameter("pronum");	//상품 번호에 맞게 가격 가져오기
	System.out.println("pronum : "+pronum);
	
	PRODUCTDAO pdao = PRODUCTDAO.getInstance();
	PRODUCTDTO pdto = pdao.getProductByNum(pronum);
%>
<style>
body{
 background-image: url(../IMAGES/ARTSHOP_MAIN_IMAGE02.jpg);
 background-size: cover;
}
</style>
<jsp:include page="GN_TOP.jsp"/>
<div class="mx-auto shadow-sm p-3 mb-5 bg-body rounded" style="width: 600px; margin-top:50px;">
  	<h2>상품주문</h2>
  	<hr>
<form method="post" name="orderform" action="GN_ORDER_PROC.jsp?pronum=<%=pronum %>&propri=<%=pdto.getPropri() %>" >
	<input type="hidden" value="" name="ordname">
  <div class="mb-3">
    <label class="form-label">이메일 :</label>
    <div class="input-group w-50">
  		<input type="text" class="form-control" placeholder="Email" name="ordemail">
	</div>
  		<input type="hidden" class="form-control" name="ordstat" value="대기">
  </div>
  <div class="mb-3">
    <label class="form-label">요청사항 :</label>
    <div class="input-group">
  		<textarea rows="5" cols="100" name="ordask"></textarea>
	</div>
  </div>
  	<div class="card mb-3" style="width: 10rem;">
  	<div class="card-header">
    	합계 :
  	</div>
  	<ul class="list-group list-group-flush">
    	<li class="list-group-item">총 <%=pdto.getPropri() %> 원</li>
  	</ul>
	</div>
  	<button type="submit" class="btn btn-primary" onClick="return writeSave()">주문하기</button>
</form>
</div>
<jsp:include page="../../ARTSHOP_MAIN_BOTTOM.jsp"/>
<%@page import="ARTSHOP.PRODUCT.PRODUCTDTO"%>
<%@page import="ARTSHOP.PRODUCT.CATEGORYDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ARTSHOP.PRODUCT.CATEGORYDAO"%>
<%@page import="ARTSHOP.PRODUCT.PRODUCTDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- PR_PRODUCTUP.jsp -->
<%
	request.setCharacterEncoding("utf-8");
	String pronum = request.getParameter("pronum");
	PRODUCTDAO pdao = PRODUCTDAO.getInstance();
	PRODUCTDTO pdto = pdao.getProductByNum(pronum); 
	System.out.println(pdto.getProsub());
	
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
  	<h2>상품수정</h2>
  	<hr>
<form method="post" name="registerform" action="PR_PRODUCTUP_PROC.jsp?pronum=<%=pronum %>" >
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">상품이름 :</label>
    <div class="input-group w-50">
  		<input type="text" class="form-control" placeholder="Product" name="prosub" value="<%=pdto.getProsub()%>">
	</div>
  </div>
  <div class="mb-3">
  		<input type="hidden" name="prowri" value="<%=pdto.getProwri()%>">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">카테고리 :</label>
    <div class="input-group w-75">
  		<select name="procat">
  			<%
  			if(lists.size() == 0){
				%>
					<option value=""> 카테고리 없음</option>
				<%
				} else{
  				for(int i=0;i<lists.size();i++){ %>
  					<option value="<%=lists.get(i).getCatname()%>" <%if(lists.get(i).getCatname().equals(pdto.getProcat())){ %>selected<%} %>><%=lists.get(i).getCatname()%></option>
  			<%}
  			}%>
  		</select>
	</div>
  	</div>
  	<div class="mb-3">
  	<label for="exampleFormControlTextarea1" class="form-label">상품설명 : </label>
  	<textarea class="form-control" id="exampleFormControlTextarea1" name="procon" rows="3"><%=pdto.getProcon()%></textarea>
	</div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">상품가격 :</label>
    <div class="input-group w-25">
  		<input type="text" class="form-control" placeholder="Price" name="propri" value="<%=pdto.getPropri()%>">
	</div>
  </div>
  	<button type="submit" class="btn btn-primary" onClick="return writeSave()">수정하기</button>
</form>
</div>
<jsp:include page="../../ARTSHOP_MAIN_BOTTOM.jsp"/>
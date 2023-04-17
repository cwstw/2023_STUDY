<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- GN_ORDER.jsp -->
<%
	request.setCharacterEncoding("utf-8");
	String pronum = request.getParameter("pronum");	//상품 번호에 맞게 옵션 가져오기+주문넣기

	OPTIONDAO odao = OPTIONDAO.getInstance();
	ArrayList<OPTIONDTO> lists = odao.getAllOptionByPronum();
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
<form method="post" name="registerform" action="GN_ORDER_PROC.jsp" >
	<input type="hidden" value="" name="ordname">
  <div class="mb-3">
    <label class="form-label">이메일 :</label>
    <div class="input-group w-50">
  		<input type="text" class="form-control" placeholder="Email" name="ordemail">
	</div>
  </div>
  <div class="mb-3">
    <label class="form-label">요청사항 :</label>
    <div class="input-group w-50">
  		<textarea rows="20" cols="5" name="ordask"></textarea>
	</div>
  </div>

  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">옵션 :</label>
    <div class="input-group w-75">
  		<select name="opname">
  			<%
  			if(lists.size() == 0){
				%>
					<option value=""> 옵션 없음</option>
				<%
				} else if(){
  				for(int i=0;i<lists.size();i++){ %>
  					<option value="<%=lists.get(i).getCatname()%>"><%=lists.get(i).getCatname()%></option>
  			<%}
  			}%>
  		</select>
	</div>
  	</div>
  	<button type="submit" class="btn btn-primary" onClick="return writeSave()">주문하기</button>
</form>
</div>
<jsp:include page="../../ARTSHOP_MAIN_BOTTOM.jsp"/>
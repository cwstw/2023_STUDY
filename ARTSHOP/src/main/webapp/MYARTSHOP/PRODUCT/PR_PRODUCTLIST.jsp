<%@page import="ARTSHOP.PRODUCT.PRODUCTDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ARTSHOP.PRODUCT.PRODUCTDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- PR_PRODUCTLIST.jsp -->
<style>
body{
	background : #e9e9e9!important;
}
</style>
<jsp:include page="PR_TOP.jsp"/>
<%
	PRODUCTDAO pdao = PRODUCTDAO.getInstance();
		String smemid = (String)session.getAttribute("smemid");
		System.out.println(smemid);
		
	String memnick = pdao.getNicknameById(smemid); 
	ArrayList<PRODUCTDTO> lists = pdao.getProductByNick(memnick);  
%>
    <!-- Page Content-->
    <h1 class="mb-5 mt-5 text-center"><%=memnick %>님의 상품 목록</h1>
    <div class="mx-auto shadow-sm p-3 mb-3 bg-body rounded" style="width: 1200px; margin-top:50px;">
    <table class="table text-center">
  		<thead>
    		<tr>
      			<th scope="col">상품번호</th>
      			<th scope="col">상품이름</th> 
      			<th scope="col">카테고리</th> 
      			<th scope="col">상품가격</th> 
      			<th scope="col">관리</th> 
    		</tr>
  		</thead>
  		<tbody>
  			<%
			if(lists.size()==0){
				out.println("<tr><td colspan=8 align='center'>등록된 상품이 없습니다.</td></tr>");
			} else{
  				for(int i=0;i<lists.size();i++){ %>
    		<tr>
      			<td><%=lists.get(i).getPronum() %></td>
      			<td><%=lists.get(i).getProsub() %></td>
      			<td><%=lists.get(i).getProcat() %></td>
      			<td><%=lists.get(i).getPropri() %></td>
      			<td>
					<div class="d-grid gap-2 d-md-block">
	  					<button class="btn btn-warning" type="button" onClick="location.href='PR_PRODUCTUP.jsp?pronum=<%=lists.get(i).getPronum() %>'">
	  						수정하기
	  					</button>
	  					<button class="btn btn-danger" type="button" onClick="location.href='PR_PRODUCTDEL.jsp?pronum=<%=lists.get(i).getPronum() %>'">
	  						삭제하기
	  					</button>
					</div>
      			</td>
    		</tr>
    		<%}//for
  			}//else%>
  		</tbody>
	</table>
	</div>
	<button class="btn btn-success mb-3" type="button" onClick="location.href='PR_PRODUCTINPUT.jsp'" style="margin-left: 1270px;">
	  	등록하기
	</button>
<jsp:include page="../../ARTSHOP_MAIN_BOTTOM.jsp"/>
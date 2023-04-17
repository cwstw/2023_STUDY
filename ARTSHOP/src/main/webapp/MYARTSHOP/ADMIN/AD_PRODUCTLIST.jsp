<%@page import="ARTSHOP.PRODUCT.PRODUCTDTO"%>
<%@page import="ARTSHOP.PRODUCT.PRODUCTDAO"%>
<%@page import="ARTSHOP.MEMBER.MEMBERDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ARTSHOP.MEMBER.MEMBERDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- AD_PRODUCTLIST.jsp -->
<style>
body{
	background : #e9e9e9!important;
}
</style>
<jsp:include page="AD_TOP.jsp"/>
    <!-- Page Content-->
    <h1 class="mb-5 mt-5 text-center">상품 목록</h1>
    <div class="mx-auto shadow-sm p-3 mb-5 bg-body rounded" style="width: 1200px; margin-top:50px;">
    <table class="table text-center">
  		<thead>
    		<tr>
      			<th scope="col">상품번호</th>
      			<th scope="col">판매자</th>
      			<th scope="col">상품이름</th> 
      			<th scope="col">카테고리</th> 
      			<th scope="col">상품가격</th> 
      			<th scope="col">슬롯</th> 
      			<th scope="col">관리</th> 
    		</tr>
  		</thead>
  		<tbody>
  			<%
  			PRODUCTDAO pdao = PRODUCTDAO.getInstance();
			ArrayList<PRODUCTDTO> lists = pdao.getAllProduct();
			if(lists.size()==0){
				out.println("<tr><td colspan=8 align='center'>등록된 상품이 없습니다.</td></tr>");
			} else{
  				for(int i=0;i<lists.size();i++){ %>
    		<tr>
      			<td><%=lists.get(i).getPronum() %></td>
      			<td><%=lists.get(i).getProwri() %></td>
      			<td><%=lists.get(i).getProsub() %></td>
      			<td><%=lists.get(i).getProcat() %></td>
      			<td><%=lists.get(i).getPropri() %></td>
      			<td>
					<div class="d-grid gap-2 d-md-block">
	  					<button class="btn btn-warning" type="button" onClick="location.href='../PRODUCT/PR_PRODUCTUP.jsp?pronum=<%=lists.get(i).getPronum() %>'">
	  						수정하기
	  					</button>
	  					 
	  					<button class="btn btn-danger" type="button" onClick="location.href='../PRODUCT/PR_PRODUCTDEL.jsp?pronum=<%=lists.get(i).getPronum() %>'">
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
<jsp:include page="../../ARTSHOP_MAIN_BOTTOM.jsp"/>
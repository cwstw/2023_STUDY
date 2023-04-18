<%@page import="ARTSHOP.MEMBER.MEMBERDTO"%>
<%@page import="ARTSHOP.STORE.ORDERDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ARTSHOP.PRODUCT.PRODUCTDAO"%>
<%@page import="ARTSHOP.MEMBER.MEMBERDAO"%>
<%@page import="ARTSHOP.STORE.ORDERDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- PR_ORDERLIST.jsp -->
<style>
body{
	background : #e9e9e9!important;
}
</style>
<jsp:include page="PR_TOP.jsp"/>
<%
	ORDERDAO odao = ORDERDAO.getInstance();
	String smemid = (String)session.getAttribute("smemid");
	MEMBERDAO mdao = MEMBERDAO.getInstance();
	PRODUCTDAO pdao = PRODUCTDAO.getInstance();
	
	String memnum = mdao.getNumById(smemid);   
	String memnick = mdao.getNickById(smemid);   
	ArrayList<ORDERDTO> lists = odao.getAllOrderByNum(Integer.parseInt(memnum));
	MEMBERDTO mdto = mdao.getMemberByMemnum(memnum);
	
%>
    <!-- Page Content-->
    <h1 class="mb-5 mt-5 text-center">주문 목록</h1>
    <div class="mx-auto shadow-sm p-3 mb-3 bg-body rounded" style="width: 1200px; margin-top:50px;">
    <table class="table text-center">
  		<thead>
    		<tr>
      			<th scope="col">주문번호</th>
      			<th scope="col">상품번호</th>
      			<th scope="col">작가이름</th>
      			<th scope="col">주문요청</th>
      			<th scope="col">상품가격</th>
      			<th scope="col">주문상태</th>
      			<th scope="col">주문확정</th>
    		</tr>
  		</thead>
  		<tbody>
  			<%
			if(lists.size()==0){
				out.println("<tr><td colspan=8 align='center'>들어온 주문이 없습니다.</td></tr>");
			} else{
				for(int i=0;i<lists.size();i++){
  				String prowri = pdao.getNicknameByNum(lists.get(i).getPronum()); 
  				String ordstat = odao.getOrdstatByNum(lists.get(i).getOrdnum()); 
  				%>
    		<tr>
      			<td><%=lists.get(i).getOrdnum() %></td>
      			<td><%=lists.get(i).getPronum() %></td>
      			<td><%=prowri %></td>
      			<td><%=lists.get(i).getOrdask() %></td>
      			<td><%=lists.get(i).getOrdpri() %></td>
      			<td><%=ordstat %></td>
      			<td>
					<div class="d-grid gap-2 d-md-block">
	  					<button class="btn btn-primary" type="button" onClick="location.href='PR_ORDERUP.jsp?ordnum=<%=lists.get(i).getOrdnum() %>'">
	  						전송완료
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
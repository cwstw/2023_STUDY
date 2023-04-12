<%@page import="ARTSHOP.MEMBER.MEMBERDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ARTSHOP.MEMBER.MEMBERDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- AD_MEMBERLIST.jsp -->
<style>
body{
	background : #e9e9e9!important;
}
</style>
<jsp:include page="AD_TOP.jsp"/>
    <!-- Page Content-->
    <h1 class="mb-5 mt-5 text-center">회원 목록</h1>
    <div class="mx-auto shadow-sm p-3 mb-5 bg-body rounded" style="width: 1200px; margin-top:50px;">
    <table class="table text-center">
  		<thead>
    		<tr>
      			<th scope="col">번호</th>
      			<th scope="col">아이디</th>
      			<th scope="col">비밀번호</th>
      			<th scope="col">이름</th> 
      			<th scope="col">닉네임</th> 
      			<th scope="col">주민등록번호</th> 
      			<th scope="col">회원종류</th> 
      			<th scope="col">관리</th> 
    		</tr>
  		</thead>
  		<tbody>
  			<%
  			MEMBERDAO mdao = MEMBERDAO.getInstance();
			ArrayList<MEMBERDTO> lists = mdao.getAllMember(); 
			if(lists.size()==0){
				out.println("<tr><td colspan=8 align='center'>등록된 회원이 없습니다.</td></tr>");
			} else{
  				for(int i=0;i<lists.size();i++){ %>
    		<tr>
      			<td><%=lists.get(i).getMemnum() %></td>
      			<td><%=lists.get(i).getMemid() %></td>
      			<td><%=lists.get(i).getMempw() %></td>
      			<td><%=lists.get(i).getMemname() %></td>
      			<td><%=lists.get(i).getMemnick() %></td>
      			<td><%=lists.get(i).getMemrrn1() %> - <%=lists.get(i).getMemrrn2() %></td>
      			<td><%=lists.get(i).getMemkind() %></td>
      			<td>
					<div class="d-grid gap-2 d-md-block">
	  					<button class="btn btn-warning" type="button" onClick="location.href='AD_MEMBERUP.jsp?memnum=<%=lists.get(i).getMemnum() %>'">
	  						수정하기
	  					</button>
	  					 
	  					<button class="btn btn-danger" type="button" onClick="location.href='AD_MEMBERDEL.jsp?memnum=<%=lists.get(i).getMemnum() %>'">
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
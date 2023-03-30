<%@page import="my.shop.CategoryDAO"%>
<%@page import="my.shop.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>  <!-- 첫줄, 두번째 tr시작   -->

<%
	ArrayList<CategoryBean> lists = new ArrayList<CategoryBean>();
	CategoryDAO cdao = CategoryDAO.getInstance();
	lists = cdao.getAllCategory(); 
%>

<!-- shopping_list.jsp -->
	<td colspan="6" align="center" valign="top">
		<b>카테고리 목록</b>
		<table border="1" width="600">
			<tr bgcolor="yellow">
				<th>번호</th>
				<th>카테고리 코드</th>
				<th>카테고리명</th>
				<th>삭제</th>
			</tr>
			<%
			if(lists.size() == 0){
				out.println("<tr><td colspan=4 align='center'>등록된 카테고리가 없습니다.</td> </tr>");
			}
			for(int i=0; i<lists.size(); i++){
			%>
				<tr>
					<td align="center"><%=lists.get(i).getCnum() %></td>
					<td align="center"><%=lists.get(i).getCode() %></td>
					<td align="center"><%=lists.get(i).getCname() %></td>
					<td align="center">
						<a href="category_delete.jsp?cnum=<%=lists.get(i).getCnum() %>">삭제</a>
					</td>
				</tr>
			<%
			} // for
			%>
		</table>
	</td>
<%@ include file="bottom.jsp" %> <!-- 두번째 /tr, 세번째 줄   -->












<%@page import="my.shop.ProductDAO"%>
<%@page import="my.shop.ProductBean"%>
<%@page import="my.shop.CategoryDAO"%>
<%@page import="my.shop.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="<%=request.getContextPath()%>/js/jquery.js"></script> 
<script type="text/javascript">
	$(docuement).ready(function(){
		$('th').addClass('m2');
		//$('th').attc('class','m2')
	});
</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css">
<%
	ArrayList<ProductBean> lists = new ArrayList<ProductBean>();
	ProductDAO pdao = ProductDAO.getInstance();
	lists = pdao.getAllProduct(); 
%>
<%@ include file="top.jsp" %>  <!-- 첫줄, 두번째 tr시작   -->

<!-- product_list.jsp -->
	<td colspan="6" align="center" valign="top">
		<b>카테고리 목록</b>
		<table border="1" width="600">
			<tr bgcolor="yellow">
				<th>번호</th>
				<th>상품코드</th>
				<th>상품명</th>
				<th>이미지</th>
				<th>가격</th>
				<th>제조사</th>
				<th>수량</th>
				<th>수정 | 삭제</th>
			</tr>
			<%
			if(lists.size() == 0){
				out.println("<tr><td colspan=4 align='center'>등록된 상품이 없습니다.</td> </tr>");
			}
			for(int i=0; i<lists.size(); i++){
			%>
				<tr>
					<td align="center"><%=lists.get(i).getPnum() %></td>
					<td align="center"><%=lists.get(i).getPcategory_fk() %></td>
					<td align="center"><%=lists.get(i).getPname() %></td>
					<td align="center"><img src="<%=request.getContextPath()%>/myshop/images/<%=lists.get(i).getPimage() %>"></td>
					<td align="center"><%=lists.get(i).getPrice() %></td>
					<td align="center"><%=lists.get(i).getPcompany() %></td>
					<td align="center"><%=lists.get(i).getPqty() %></td>
					<td align="center">
						<a href="product_update.jsp?cnum=<%=lists.get(i).getPnum() %>">수정</a> | 
						<a href="product_delete.jsp?cnum=<%=lists.get(i).getPnum() %>">삭제</a>
					</td>
				</tr>
			<%
			} // for
			%>
		</table>
	</td>
<%@ include file="bottom.jsp" %> <!-- 두번째 /tr, 세번째 줄   -->




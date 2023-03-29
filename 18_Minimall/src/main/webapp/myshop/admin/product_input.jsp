<%@page import="my.shop.CategoryBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="my.shop.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css">
<!-- product_input.jsp<br> -->
<%@ include file="top.jsp" %> 
<script src="<%=request.getContextPath()%>/js/jquery.js"></script> 
<script type="text/javascript">
	$(docuement).ready(function(){
		$('th').addClass('m2');
		//$('th').attc('class','m2')
	});
</script>
<%
	String[] pspec = {"::NORMAL::","HIT","NEW","BEST"};
	
	CategoryDAO cdao = CategoryDAO.getInstance();
	ArrayList<CategoryBean> lists = cdao.getAllCategory();
	/* 모든 th에 m2 class 추가해라 */
%>
<td colspan="6" align="center" valign="top">
	<!-- product_input.jsp<br> -->
	<b>상품등록카테고리</b>
	
	<form action="productProc.jsp" method="post">
	<table width="600" class="outline">
		<tr>
			<th>카테고리</th>
			<td>
				<select name="pcategory_fk"><!-- pcategory_fk=man, woman -->
					<%
					if(lists.size() == 0){
					%>
						<option value=""> 카테고리 없음</option>
					<%
					} else{
					
						for(CategoryBean cate : lists){
						%>
							<option value="<%=cate.getCode()%>"><%=cate.getCname()%>[<%=cate.getCode()%>]</option>
						<%
						}//for
					} // else
					%>
				</select>
			</td>
		</tr>
		
		<tr>
			<th>상품명</th>
			<td><input type="text" name="pname" value="이름"></td>
		</tr>
		
		<tr>
			<th>상품코드</th>
			<td><input type="text" name="pcode" value="이름"></td>
		</tr>
		
		<tr>
			<th>제조회사</th>
			<td><input type="text" name="pcompany" value="이름"></td>
		</tr>
		
		<tr>
			<th>상품이미지</th>
			<td>
				<input type="file" name="pimage"><br>
			</td>
		</tr>
		
		<tr>
			<th>상품 수량</th>
			<td><input type="text" name="pqty" maxlength="5" value="3"></td>
		</tr>
		
		<tr>
			<th>상품 가격</th>
			<td><input type="text" name="price" value="100"></td>
		</tr>
		
		<tr>
			<th>상품 스펙</th>
			<td>
				<select name="pspec">
					<%
					for(String x : pspec){
					%>
						<option value="<%=x%>"><%=x%></option>
					<%
					}
					%>
				</select>
			</td>
		</tr>
		
		<tr>
			<th>상품 소개</th>
			<td>
				<textarea rows="4" cols="50" name="pcontents">설명</textarea>
			</td>
		</tr>
		
		<tr>
			<th>상품 포인트</th>
			<td><input type="text" name="point" value="100"></td>
		</tr>
		
		<tr bgcolor="#aaa">
			<td colspan="2" align="center" class="m1">
				<input type="submit" value="상품 등록">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
	</form>
		
		
	</td>
<%@ include file="bottom.jsp" %>  

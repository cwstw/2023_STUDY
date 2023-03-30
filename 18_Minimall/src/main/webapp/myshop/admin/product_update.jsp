<%@page import="my.shop.ProductBean"%>
<%@page import="my.shop.ProductDAO"%>
<%@page import="my.shop.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- product_list.jsp(수정클릭, pnum) => product_update.jsp -->
<%
String pnum = request.getParameter("pnum");
ProductDAO pdao = ProductDAO.getInstance();
ProductBean pb = pdao.getProductByPnum(pnum); 
%>    
<%@ include file="top.jsp" %>  

<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$('th').addClass('m2');
		//$('th').attr('class','m2');
	});
</script>
		
<%
	String[] pspec = {"::NORMAL::","HIT","NEW","BEST"};
	
%>
<td colspan="6" align="center" valign="top">
	<b>상품수정</b>
	
	<form action="productUpdateProc.jsp" method="post" enctype="multipart/form-data"> 
	<table width="600" class="outline">
		<tr>
			<th>카테고리</th>
			<td>
				<input type="text" name="pcategory_fk" value="<%=pb.getPcategory_fk()%>" disabled>
			</td>
		</tr>
		<tr>
			<th>상품번호</th>
			<td>
			<%=pnum%> <!-- input에 쓰지 않으면 넘어가지 않는다. -->
			<input type="hidden" name="pnum" value="<%=pnum%>">
			</td> 
		</tr>
		<tr>
			<th>상품명</th>
			<td><input type="text" name="pname" value="이름" value="<%=pb.getPname()%>"></td>
		</tr>
		
		<tr>
			<th>제조회사</th>
			<td><input type="text" name="pcompany" value="이름" value="<%=pb.getPcompany()%>"></td>
		</tr>
		
		<tr>
			<th>상품이미지</th>
			<td>
				<img alt="없음" src="<%=request.getContextPath()%>/myshop/images/<%=pb.getPimage()%>" width="100">
				<input type="file" name="pimage"><br>
				<input type="text" name="pimageold" value="<%=pb.getPimage()%>"> <!-- 기존이미지.jpg -->
			</td>
		</tr>
		
		<tr>
			<th>상품 수량</th>
			<td><input type="text" name="pqty" maxlength="5" value="3" value="<%=pb.getPqty()%>"></td>
		</tr>
		
		<tr>
			<th>상품 가격</th>
			<td><input type="text" name="price" value="100" value="<%=pb.getPrice()%>"></td>
		</tr>
		
		<tr>
			<th>상품 스펙</th>
			<td>
				<select name="pspec">
					<%
					for(String x : pspec){
					%>
						<option value="<%=x%>"<%if(pb.getPspec().equals(x)){%>selected<%} %>><%=x%></option>
					<%
					}
					%>
				</select>
			</td>
		</tr>
		
		<tr>
			<th>상품 소개</th>
			<td>
				<textarea rows="4" cols="50" name="pcontents" style="resize:none"><%=pb.getPcontents()%></textarea>
			</td>
		</tr>
		
		<tr>
			<th>상품 포인트</th>
			<td><input type="text" name="point" value="100" value="<%=pb.getPoint()%>"></td>  
		</tr>
		
		<tr bgcolor="#aaa">
			<td colspan="2" align="center" class="m1">
				<input type="submit" value="상품 수정">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
	</form>
		
	</td>
<%@ include file="bottom.jsp" %>  

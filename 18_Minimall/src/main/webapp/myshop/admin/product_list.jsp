<%@page import="my.shop.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="my.shop.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<script>
	function deleteCheck(pnum, pimage){
		//alert(1);
		//대화상자 : alert, confrim, prompt
		var isDel = confirm("정말 삭제하시겠습니까?");
		
		if(isDel){//확인
			location.href="product_delete.jsp?pnum="+pnum+"pimage="+pimage;
		} 
	}
</script>
<%@ include file="top.jsp" %>
<td colspan="6" align="center" valign="top">
	
	<table class="outline" width="700">
			<b>상품목록</b>
			<tr class="m2">
				<th align="center">번호</th>
				<th align="center">상품코드</th>
				<th align="center">상품명</th>
				<th align="center">이미지</th>
				<th align="center">가격</th>
				<th align="center">제조사</th>
				<th align="center">수량</th>
				<th align="center">수정 | 삭제</th>
			</tr>
			
				<%
				ProductDAO dao = ProductDAO.getInstance();
				ArrayList<ProductBean> list = dao.getAllProduct();
				if(list.size()==0){
					out.println("<tr><td colspan=8 align='center'>등록된 상품이 없습니다.</td></tr>");
				} else{
				
					for (ProductBean pb : list) {
					%>
					<tr>
						<td align="center"><%=pb.getPnum()%></td>
						<td align="center"><%=pb.getPcategory_fk()%></td>
						<td align="center"><%=pb.getPname()%></td>
						<td align="center">
							<a href="product_view.jsp?<%=pb.getPnum()%>">
								<img  alt="없음" src="<%=request.getContextPath()%>/myshop/images/<%=pb.getPimage()%>" width="30">
							</a>
						</td>
						<td align="center"><%=pb.getPrice()%></td>
						<td align="center"><%=pb.getPcompany()%></td>
						<td align="right"><%=pb.getPqty()%></td>
						<td align="center">
							<a href="">수정</a> | 
							<%-- <a href="product_delete.jsp?pnum=<%=pb.getPnum()%>&pimage=<%=pb.getPimage()%>" onClick="return deleteCheck()">삭제</a> --%>
							<a href="javascript:deleteCheck('<%=pb.getPnum()%>','<%=pb.getPimage()%>')">삭제</a>
						</td>
					</tr>
	
					<%
					}//for
				}//else
				%>

		</table>	
	
</td>
<%@ include file="bottom.jsp" %>
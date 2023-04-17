<%@page import="ARTSHOP.PRODUCT.PRODUCTDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- AD_PRODUCTDEL.jsp -->
<%
	request.setCharacterEncoding("utf-8");
	String pronum = request.getParameter("pronum");
	PRODUCTDAO pdao = PRODUCTDAO.getInstance();
	
	String msg="", url="";
	int cnt = pdao.deleteProduct(pronum);  
		
		if(cnt >0){
			msg = "상품 삭제 성공!";
			url = "PR_PRODUCTLIST.jsp";
		}else{
			msg = "상품 삭제 실패!";
			url = "PR_PRODUCTLIST.jsp";
		}//else
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
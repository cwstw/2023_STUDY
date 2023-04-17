<%@page import="ARTSHOP.PRODUCT.PRODUCTDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- PR_PRODUCTUP_PROC.jsp -->
<%
	request.setCharacterEncoding("utf-8");
	String pronum = request.getParameter("pronum");
	PRODUCTDAO pdao = PRODUCTDAO.getInstance();
%>
<jsp:useBean id="pdto" class="ARTSHOP.PRODUCT.PRODUCTDTO"/>
<jsp:setProperty property="*" name="pdto"/>
<%
	String msg="", url="";
	int cnt = pdao.updateProduct(pdto, pronum); 
		
		if(cnt >0){
			msg = "상품 수정 성공!";
			url = "PR_PRODUCTLIST.jsp";
		}else{
			msg = "상품 수정 실패!";
			url = "PR_PRODUCTLIST.jsp";
		}//else
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
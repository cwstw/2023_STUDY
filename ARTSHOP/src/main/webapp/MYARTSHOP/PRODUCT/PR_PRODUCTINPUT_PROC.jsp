<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="ARTSHOP.PRODUCT.PRODUCTDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- PR_PRODUCTINPUT_PROC.jsp -->
<%
	request.setCharacterEncoding("utf-8");
	PRODUCTDAO pdao = PRODUCTDAO.getInstance();
%>
<jsp:useBean id="pdto" class="ARTSHOP.PRODUCT.PRODUCTDTO"/>
<jsp:setProperty property="*" name="pdto"/>
<%
	System.out.println("제목  :"+pdto.getProsub());
	String msg="", url="";
	int cnt = pdao.insertProduct(pdto); 
		
		if(cnt >0){
			msg = "상품 등록 성공!";
			url = "PR_PRODUCTLIST.jsp";
		}else{
			msg = "상품 등록 실패!";
			url = "PR_PRODUCTLIST.jsp";
		}//else
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
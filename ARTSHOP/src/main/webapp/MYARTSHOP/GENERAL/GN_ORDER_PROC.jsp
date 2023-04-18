<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- GN_ORDER_PROC.jsp -->
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
			msg = "주문 완료!";
			url = "GN_ORDERLIST.jsp";
		}else{
			msg = "주문 실패!";
			url = "GN_ORDER.jsp";
		}//else
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
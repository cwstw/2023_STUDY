<%@page import="ARTSHOP.STORE.ORDERDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- PR_ORDERUP.jsp -->
<%
	request.setCharacterEncoding("utf-8");
	String ordnum = request.getParameter("ordnum");
	
	ORDERDAO odao = ORDERDAO.getInstance();

	String msg="", url="";
	int cnt = odao.updateOrdstat2(ordnum); 
		
		if(cnt >0){
			msg = "상태 수정 완료!";
			url = "GN_MY_ORDERLIST.jsp";
		}else{
			msg = "상태 수정 실패!";
			url = "GN_MY_ORDERLIST.jsp";
		}//else
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
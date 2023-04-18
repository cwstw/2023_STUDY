<%@page import="ARTSHOP.MEMBER.MEMBERDAO"%>
<%@page import="ARTSHOP.STORE.ORDERDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- GN_ORDER_PROC.jsp -->
<%
	request.setCharacterEncoding("utf-8");
	String smemid = (String)session.getAttribute("smemid");
	String pronum = request.getParameter("pronum");
	String propri = request.getParameter("propri");
	
	MEMBERDAO mdao = MEMBERDAO.getInstance();
	String memnum = mdao.getNumById(smemid);  
	ORDERDAO odao = ORDERDAO.getInstance();
%>
<jsp:useBean id="odto" class="ARTSHOP.STORE.ORDERDTO"/>
<jsp:setProperty property="*" name="odto"/>
<%
	String msg="", url="";
	int cnt = odao.insertOrder(odto,memnum,pronum,propri); 
		
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
<%@page import="ARTSHOP.MEMBER.MEMBERDAO"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"
	import="java.sql.*" %>

<%
	String userid = request.getParameter("userid");
	System.out.println("userid : " + userid);
	
	MEMBERDAO mdao = MEMBERDAO.getInstance();
	boolean result = mdao.searchId(userid);
	 
	System.out.println("result : "+result);
	
	if(result){
		out.print("NO");
	} else{
		out.print("YES");
	}
	
%>




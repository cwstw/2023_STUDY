<%@page import="my.member.MemberDAO"%>
<%@ page contentType="text/html; charset=UTF-8" language="java"
	import="java.sql.*" %>

<%
	//idCheckProc.jsp<br>
	String userid = request.getParameter("userid");
	System.out.println("userid" + userid);
	
	MemberDAO mdao = MemberDAO.getInstance();
	boolean result = mdao.searchId(userid); 
	
	System.out.println("result"+result);
	
	if(result){
		out.print("NO");
	} else{
		out.print("YES");
	}
	
%>




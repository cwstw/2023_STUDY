<%@page import="ARTSHOP.MEMBER.MEMBERDTO"%>
<%@page import="ARTSHOP.MEMBER.MEMBERDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!-- FINDID_PROC.jsp -->
<%
	request.setCharacterEncoding("UTF-8");
	String memname = request.getParameter("memname");
	String memrrn1 = request.getParameter("memrrn1");
	String memrrn2 = request.getParameter("memrrn2");

	MEMBERDAO mdao = MEMBERDAO.getInstance();
	MEMBERDTO member = mdao.findId(memname, memrrn1, memrrn2);

	String msg="",url="";
	if(member!=null){
		msg = "회원님의 아이디는 "+member.getMemid()+"입니다.";
		url = "LOGIN.jsp";
	} else{
		msg = "입력하신 정보가 틀리거나 없는 회원입니다.";
		url = "FINDID.jsp";
	}
%>
<script>
	alert(<%=msg%>);
	location.href="<%=url%>";
</script>
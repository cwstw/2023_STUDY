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
		msg = "ȸ������ ���̵�� "+member.getMemid()+"�Դϴ�.";
		url = "LOGIN.jsp";
	} else{
		msg = "�Է��Ͻ� ������ Ʋ���ų� ���� ȸ���Դϴ�.";
		url = "FINDID.jsp";
	}
%>
<script>
	alert(<%=msg%>);
	location.href="<%=url%>";
</script>
<%@page import="ARTSHOP.MEMBER.MEMBERDTO"%>
<%@page import="ARTSHOP.MEMBER.MEMBERDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
FINDPW_PROC.jsp<BR>
<%
	request.setCharacterEncoding("UTF-8");
%>
	<jsp:useBean id="mdto" class="ARTSHOP.MEMBER.MEMBERDTO" />
	<jsp:setProperty property="*" name="mdto" />
<%
	System.out.println(mdto.getMemid()+","+mdto.getMemname()+","+mdto.getMemrrn1()+","+mdto.getMemrrn2());
	MEMBERDAO mdao = MEMBERDAO.getInstance();
	MEMBERDTO member = mdao.findPw(mdto);

	String msg="",url="";
	if(member!=null){
		msg = "회원님의 비밀번호는 "+member.getMempw()+"입니다.";
		url = "LOGIN.jsp";
	} else{
		msg = "입력하신 정보가 틀리거나 없는 회원입니다.";
		url = "FINDPW.jsp";
	}
%>
<script>
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
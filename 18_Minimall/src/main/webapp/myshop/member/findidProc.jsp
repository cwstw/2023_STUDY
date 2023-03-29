<%@page import="my.member.MemberDTO"%>
<%@page import="my.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
findidProc.jsp<br> 

<%
	request.setCharacterEncoding("UTF-8");
	MemberDAO dao = MemberDAO.getInstance();
	%>
	<jsp:useBean id="mb" class="my.member.MemberDTO" />
	<jsp:setProperty property="*" name="mb" />


<%
	MemberDTO member = dao.getIdbyRrn(mb); 
	System.out.println(member);
	
	String msg,url;
	if (member != null) {
		msg = member.getId();
	
	} else {
		msg = "없는 회원";
	}
	url = request.getContextPath()+"/main.jsp";
	%>	
	
<script type="text/javascript">
	alert("<%=msg%>"+"입니다.");
	location.href="<%=url%>";
</script>	
	
	
	
	
	
	
	
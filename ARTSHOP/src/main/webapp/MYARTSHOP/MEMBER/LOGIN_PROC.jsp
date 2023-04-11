<%@page import="ARTSHOP.MEMBER.MEMBERDAO"%>
<%@page import="ARTSHOP.MEMBER.MEMBERDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String memid = request.getParameter("memid");
	String mempw = request.getParameter("mempw");
	
	MEMBERDAO mdao = MEMBERDAO.getInstance();
	MEMBERDTO member = mdao.getMemberInfo(memid,mempw); 
	
	String viewPage = null;
	
	if(member != null){ // 존재한다.(찾았다, 등록한 회원)
		String _memkind = member.getMemkind();
		int memnum = member.getMemnum();
		//id를 다른 페이지에서도 사용할 수 있도록 세션 설정
		//("별칭", 값)
		session.setAttribute("smemid", memid); 
		session.setAttribute("smemnum", memnum);
		
		
		if(_memkind.equals("운영")){ // 관리자
			viewPage = request.getContextPath()+"/MYARTSHOP/ADMIN/AD_MAIN.jsp";
		}else{ // 일반사용자
			viewPage = request.getContextPath()+"/MYARTSHOP/GENERAL/GN_MAIN.jsp";
		}
	}else{ // 존재하지 않는 회원
		viewPage =  "LOGIN.jsp";
	%>
		<script type="text/javascript">
			alert("등록되지 않은 아이디 혹은 비밀번호입니다.");
		</script>
	<%
	}
%>

<script type="text/javascript">
	location.href="<%=viewPage%>";
</script>

    
<%@page import="ARTSHOP.MEMBER.MEMBERDAO"%>
<%@page import="ARTSHOP.MEMBER.MEMBERDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("memid");
	String password = request.getParameter("mempw");
	
	MEMBERDAO mdao = MEMBERDAO.getInstance();
	MEMBERDTO member = mdao.getMemberInfo(id,password); 
	
	String viewPage = null;
	
	if(member != null){ // 존재한다.(찾았다, 등록한 회원)
		String _memkind = member.getMemid();
		int no = member.getMemnum();
		//id를 다른 페이지에서도 사용할 수 있도록 세션 설정
		//("별칭", 값)
		session.setAttribute("smemid", memid);
		session.setAttribute("smemno", memno);
		
		
		if(_memkind.equals("운영")){ // 관리자
			viewPage = request.getContextPath()+"/myshop/admin/main.jsp";
		}else{ // 일반사용자
			viewPage = request.getContextPath()+"/myshop/display/mall.jsp";
		}
	}else{ // 존재하지 않는 회원
		viewPage =  "main.jsp";
	%>
		<script type="text/javascript">
			alert("가입하지 않은 회원입니다.");
		</script>
	<%
	}
%>

<script type="text/javascript">
	location.href="<%=viewPage%>";
</script>

    
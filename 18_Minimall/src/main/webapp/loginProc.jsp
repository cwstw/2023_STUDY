<%@page import="my.member.MemberDTO"%>
<%@page import="my.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
loginProc.jsp<br>

<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	MemberDAO mdao = MemberDAO.getInstance();
	MemberDTO member = mdao.getMemberInfo(id,password); 
	
	String viewPage = null;
	
	if(member != null){ // 존재한다.(찾았다, 등록한 회원)
		String _id = member.getId();
	
		//id를 다른 페이지에서도 사용할 수 있도록 세션 설정
		//("별칭", 값)
		session.setAttribute("sid", id);
		
		
		if(_id.equals("admin")){ // 관리자
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


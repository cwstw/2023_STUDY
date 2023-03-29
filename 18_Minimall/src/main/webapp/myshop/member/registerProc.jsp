<%@page import="my.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
register.jsp => myshop\member\registerProc.jsp<br>

<%
	request.setCharacterEncoding("utf-8");
	
	MemberDAO mdao = MemberDAO.getInstance();
%>
<jsp:useBean id="md" class="my.member.MemberDTO"></jsp:useBean>
<jsp:setProperty property="*" name="md"/>
<%

	int cnt = mdao.insertMember(md);  
	String msg="", url="";
	if(cnt == 1){
		msg = "가입 성공";
		url = request.getContextPath()+"/main.jsp"; //
	}else{
		msg = "가입 실패";
		url = "register.jsp";
	}
%>
<script type="text/javascript">
	alert("<%=msg %>"+"했습니다.");
	location.href="<%=url%>";
	//location.href=main.jsp
</script>

<!-- 삽입 성공하면=>로그인 화면으로 이동
실패 하면 => register로 이동

alert(가입 성공)
alert(가입 실패)
request.getContextPath() 출력해보면 18_Minimall이라고 나오지만
18_Minimall\src\main\webapp까지 포함한다.
 -->
 
 
 
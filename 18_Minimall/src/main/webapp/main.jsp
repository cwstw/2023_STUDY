<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="style.css">	
main.jsp<br>
<%-- <%=request.getContextPath()%> <br> --%>
[로그인 화면] <br><br>
<form action="loginProc.jsp" method="post">

	<table border="1">   
		<tr>
			<td bgcolor="yellow">아이디</td>
			<td><input type="text" name="id" value="admin">
		</tr>

		<tr>
			<td bgcolor="yellow">비번</td>
			<td><input type="password" name="password" value="1234">
		</tr>

		<tr>
			<td colspan="2" bgcolor="#ffcc00">
				<input type="submit" value="로그인"> 
				<input type="button" value="회원가입" onClick="location.href='<%=request.getContextPath()%>/myshop/member/register.jsp'"> 
				<input type="button" value="아이디 찾기" onClick="location.href='<%=request.getContextPath()%>/myshop/member/findid.jsp'"> 
				<input type="button" value="비번찾기"  onClick="location.href='<%=request.getContextPath()%>/myshop/member/findpw.jsp'">
			</td>
		</tr>
	</table>

</form>
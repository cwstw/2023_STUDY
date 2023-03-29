<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath()%>/style.css">    
findid.jsp<br>


<form action="findidProc.jsp" method="post">
	<table border="1" align="center">
		<tr>
			<td align="center" bgcolor="yellow">이름</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td align="center" bgcolor="yellow">주민 등록 번호</td>
			<td><input type="text" name="rrn1">-<input type="text" name="rrn2"></td>
		</tr>
		
		<tr>
		<td colspan="2" bgcolor="#ffcc00" align="center">
			<input type="submit" value="아이디 찾기" >
		</td>
		</tr>
	</table>
</form>
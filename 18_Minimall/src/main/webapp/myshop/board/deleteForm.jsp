<%@page import="Board.BoardBean"%>
<%@page import="Board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="color.jsp" %>
<jsp:include page ="./../display/mall_top.jsp"/>
<link rel="stylesheet" type="text/css" href="./style.css">
<style>
	body{
		text-align: center;
		background: <%=bodyback_c %>
	}
	table{
		margin:auto;
		width:500px;
		height:120px;
		text-align: center;
	}
	th{
		background: <%=value_c%>
	}
</style>
<script src="js/jquery.js"></script>
<script src="script.js"></script>
<!-- ==============style/script============== -->
<%
	String num = request.getParameter("num");
	String pageNum = request.getParameter("pageNum");
%>


<h3>글삭제</h3>
<!-- 히든으로 넘기거나 주소뒤에 적거나 둘 중 하나로 넘기면 됨 -->
<form method="post" name="deleteform" action="deleteProc.jsp?<%=num %>&pageNum=<%=pageNum %>" onSubmit="return writeSave()">
<input type="hidden" name="num" value="<%=num%>">
<table>
	<tr>
		<th>비밀번호를 입력하세요.</th>
	</tr>
	<tr>
		<td>비밀번호 : <input type="password" name="passwd" style="width:70px"></td>
	</tr>
	
	<tr>
		<th>
			<input type="submit" id="sub" value="글삭제">
			<input type="button" value="목록보기" onClick="location.href='select.jsp?pageNum=<%=pageNum%>'">
		</th>
	</tr>
</table>
</form>
<jsp:include page ="./../display/mall_bottom.jsp"/>


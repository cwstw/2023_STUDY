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
		/* width:700px; */
	
	}
	th{
		background: <%=value_c%>
	}
</style>
<script src="js/jquery.js"></script>
<script src="script.js"></script>
<!-- <script>
	function writeSave(){
		//alert(1);
	}
</script> -->
<!-- ==============style/script============== -->

<h3>글쓰기</h3>

<form method="post" name="wirteform" action="writeProc.jsp" onSubmit="return writeSave()">
<table width="600px">
	<tr>
		<th colspan="2" align="right">
			<a href="select.jsp">글목록</a>
		</th>
	</tr>
	<tr>
		<th>이 름</th>
		<td><input type="text" name="writer" value="<%=session.getAttribute("sid")%>"></td>
	</tr>
	<tr>
		<th>제 목</th>
		<td><input type="text" name="subject"></td>
	</tr>
	<tr>
		<th>Email</th>
		<td><input type="text" name="email"></td>
	</tr>
	<tr>
		<th>내 용</th>
		<td><textarea name="content" rows="20" cols="95"></textarea></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="passwd"></td>
	</tr>
	<tr>
		<th colspan="2">
			<input type="submit" id="sub" value="글쓰기">
			<input type="reset" value="다시작성">
			<input type="button" value="목록보기" onClick="location.href='select.jsp'">
		</th>
	</tr>
</table>
</form>

<jsp:include page ="./../display/mall_bottom.jsp"/>

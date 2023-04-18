<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- BD_WRITEFORM.jsp -->
<jsp:include page="../../ARTSHOP_MAIN_TOP.jsp"/>P.jsp"/> 
<style>
	body{
		text-align: center;
	}
	table{
		margin:auto;
		/* width:700px; */
	
	}
</style>
<h3 class="m-3">글쓰기</h3>

<form method="post" name="wirteform" action="BD_WRITEPROC.jsp.jsp" onSubmit="return writeSave()">
<table width="600px">
	<tr>
		<th colspan="2" align="right">
			<a href="select.jsp" class="m-3">글목록</a>
		</th>
	</tr>
	<tr>
		<th>이 름</th>
		<td><input type="text"name="writer" value="<%=session.getAttribute("sid")%>"></td>
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

<jsp:include page="../../ARTSHOP_MAIN_BOTTOM.jsp"/>

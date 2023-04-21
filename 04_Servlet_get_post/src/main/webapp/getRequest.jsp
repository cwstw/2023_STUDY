<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function movePage(){
		location.href="request.do";
	}
</script>
getRequest.jsp<br><br>

<a href="request.do">링크</a><br><br><br>

<input type="button" value="get요청" onClick="movePage()"/><br><br>

<form action="request.do" method="get">
	<input type="submit" value="get방식 호출">
</form>
<br><br>
<form action="request.do" method="post">
	<input type="submit" value="post방식 호출">
</form>
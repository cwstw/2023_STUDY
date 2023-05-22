<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- member/memberLoginForm.jsp -->
<script>
	function register(){
		location.href="regisertForm.mb";
	}
</script>
<form action="login" method="">
	<table border="1" height="150px">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="password"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인">
				<input type="reset" value="취소">
				<input type="button" value="회원가입" onClick="register()">
				<input type="button" value="회원목록보기">
			</td>
		</tr>
	</table>
</form>
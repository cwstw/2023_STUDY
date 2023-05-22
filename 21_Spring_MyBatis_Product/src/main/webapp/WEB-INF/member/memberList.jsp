<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>
<!-- memberList.jsp -->
<script>
	function insert(){
		location.href="registerForm.mb";
	}
</script>
<center>
	<h2>회원 리스트 화면</h2>
	
	<!-- 검색 -->
	<form action="list.mb" method="get">
	<select name="whatColumn">
		<option value="">전체검색</option>
		<option value="name">이름검색</option>
		<option value="gender">성별검색</option>
	</select>
	<input type="text" name="keyword">
	<input type="submit" value="검색">
	</form>
	
	<!-- 리스트 -->
	<table>
		<tr>
			<td colspan="9" align="right">
				<input type="button" value="추가하기" onClick="insert()">
			</td>
		</tr>
		<tr>
			<td>ID</td>
			<td>이름</td>
			<td>비번</td>
			<td>성별</td>
			<td>취미</td>
			<td>주소</td>
			<td>포인트</td>
			<td>삭제</td>
			<td>수정</td>
		</tr>
		<c:forEach var="member" items="${memberLists }">
		<tr>
			<td>${member.id}</td>
			<td><a href="detail.mb?num=${member.num}&pageNumber=${pageNumeber}">${member.name}</a></td>
			<td>${member.password}</td>
			<td>${member.gender}</td>
			<td>${member.hobby}</td>
			<td>${member.address}</td>
			<td>${member.mpoint}</td>
			<td><a href="delete.mb?num=${member.num}&pageNumber=${pageNumeber}">삭제</a></td>
			<td><a href="delete.mb?num=${member.num}&pageNumber=${pageNumeber}">수정</a></td>
		</tr>
		</c:forEach>
	</table>
	
	<!-- 페이징 -->
	${pageInfo.pagingHtml}
</center>
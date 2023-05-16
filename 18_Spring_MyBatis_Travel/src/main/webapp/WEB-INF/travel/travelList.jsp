<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<!-- travelList.jsp -->
<script>
	function insert(){
		location.href="insert.tv";
	}
	function goUpdate(num, pageNumber){
		location.href="update.tv?num="+num+"&pageNumber="+pageNumber;
	}
</script>
<center>
<h3>여행 리스트 화면</h3>

<form action="list.tv" method="get">
<select name="whatColumn">
	<option value="">전체선택</option>
	<option value="area">관심지역</option>
	<option value="style">여행타입</option>
</select>
<input type="text" name="keyword">
<input type="submit" value="검색">
</form>

<table border="1">
	<tr>
		<td colspan="8" align="right">
			<input type="button" value="추가하기" onClick="insert()">
		</td>
	</tr>
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>나이</td>
		<td>관심지역</td>
		<td>여행타입</td>
		<td>예상비용</td>
		<td>삭제</td>
		<td>수정</td>
	</tr>
	
	<c:if test="${fn:length(lists)==0}">
	<tr>
		<td colspan="8" align="right" style="text-align:center;">
			검색어에 해당하는 레코드가 없습니다
		</td>
	</tr>
	</c:if>
	
	<c:forEach var="travel" items="${lists}">
	<tr>
		<td>${travel.num}</td>
		<td><a href="detail.tv?num=${travel.num}&pageNumber=${pageInfo.pageNumber}">${travel.name}</a></td>
		<td>${travel.age}</td>
		<td>${travel.area}</td>
		<td>${travel.style}</td>
		<td>${travel.price}</td>
		<td><a href="delete.tv?num=${travel.num}">삭제</a></td>
		<td>
		<input type="button" value="수정" onClick="goUpdate(${travel.num}, ${pageInfo.pageNumber})">
		</td>
	</tr>
	</c:forEach>
</table>
</center>
<center>
${pageInfo.getPagingHtml()}
</center>
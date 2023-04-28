<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Board.BoardBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Board.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="color.jsp" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
   
select.jsp <br>
<style>
	body{
		text-align: center;
	}
	table{
		margin : auto;
		width : 700px;
	} 
</style>
<b>글목록(전체 글:${requestScope.count })</b>
<table>
	<tr>
		<td align="right" bgcolor="<%=value_c%>">
			<a href="writeForm.jsp">글쓰기</a>
		</td>
	</tr>
</table>

<c:if test="${count==0}">
	<table>
		<tr>
			<td align="center" bgcolor="#b0e0e6">
				게시판에 저장된 글이 없습니다.
			</td>
		</tr>
	</table>
</c:if>
<c:if test="${count!=0}">
		<table>
			<tr height="30">
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
				<th>IP</th>
			</tr>
			<c:set var="number" value="${number+1 }"/>
			
			<c:forEach var="article" items="${list }">
				<td height="30" align="center" >  
					<c:set var="number" value="${number-1 }"/>
					${number }
				</td>
					<td align="left">
					<c:if test="${article.re_level > 0 }">
						<c:set var="wid" value="${article.re_level*20 }"/>
								<img src="images/level.gif" width="${wid }" height="15">
								<img src="images/re.gif">
					</c:if>
						
						<a href="content.bd?num=${article.num}&pageNum=${pageNum}">${article.getSubject() }</a>
						
						<c:if test="${article.readcount >=10 }">
								<img src="images/hot.gif" height="15">
						</c:if>
					</td>
					<td>${article.writer }</td>
					<td>${article.reg_date }</td>
					<td>${article.readcount }</td>
					<td>${article.ip }</td>
				<tr>
			</c:forEach>
			
		</table>
</c:if>

	<c:if test="${count>0 }">
		<c:if test="${startPage >3 }">
			<a href="list.bd?pageNum=${startPage -3}">[이전]</a>
		</c:if>
		
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			<a href="list.bd?pageNum=${i }">[${i }]</a>
		</c:forEach>
		
		<c:if test="${endPage < pageCount }">
			<a href="list.bd?pageNum=${startPage + 3 }">[다음]</a>
		</c:if>
	</c:if>

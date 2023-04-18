<%@page import="ARTSHOP.BOARD.BOARDDTO"%>
<%@page import="ARTSHOP.BOARD.BOARDDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- BD_CONTENT.jsp -->
<jsp:include page="../../ARTSHOP_MAIN_TOP.jsp"/>
<style>
	body{
		text-align: center;
	}
	table{
		margin:auto;
		width:700px;
		text-align: center;
	}
	th{
	}
</style>

<h3 class="m-3">글 내용 보기</h3>
<%
	request.setCharacterEncoding("utf-8");
	BOARDDAO bdao = BOARDDAO.getInstance();
	
	String num = request.getParameter("num");
	String pageNum = request.getParameter("pageNum");
	BOARDDTO article = bdao.getArticleByNum(num); 
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
%>

<form name="contentForm">
<table>
	<tr>
		<th>글번호</th>
		<td><%=article.getNum() %></td>
		<th>조회수</th>
		<td><%=article.getReadcount() %></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><%=article.getWriter() %></td>
		<th>작성일</th>
		<td><%=sdf.format(article.getReg_date()) %></td>
	</tr>
	<tr>
		<th>글제목</th>
		<td colspan="3"><%=article.getSubject() %></td>
	</tr>
	<tr height="100px">
		<th>글내용</th>
		<td colspan="3"><pre><%=article.getContent()%></pre></td>
	</tr>
	<tr>
		<th colspan="4" align="right">
			<input type="button" id="update" value="글수정" onClick="location.href='updateForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>'">
			<input type="button" id="delete" value="글삭제" onClick="location.href='deleteForm.jsp?num=<%=article.getNum()%>&pageNum=<%=pageNum%>'">
			<input type="button" id="re" value="답글쓰기" onClick="location.href='replyForm.jsp?ref=<%=article.getRef()%>&re_step=<%=article.getRe_step()%>&re_level=<%=article.getRe_level()%>&pageNum=<%=pageNum%>'">
			<input type="button" id="select" value="글목록" onClick="location.href='select.jsp'">
		</th>
	</tr>
</table>
</form>
<jsp:include page="../../ARTSHOP_MAIN_BOTTOM.jsp"/>
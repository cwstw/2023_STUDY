<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Board.BoardBean"%>
<%@page import="Board.BoardDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="color.jsp" %>    
<link rel="stylesheet" type="text/css" href="./style.css">


<style>
	body{
		text-align: center;
		background: <%=bodyback_c %>
	}
	table{
		margin:auto;
		width:700px;
	}
</style>
<script src="js/jquery.js"></script>
<script>

</script>
<!-- ==============style/script============== -->
select.jsp<br>

<%
	int pageSize = 5;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
	
	String pageNum = request.getParameter("pageNum");//내가 선택한 페이지 번호
	System.out.println("pageNum : "+pageNum);
	if(pageNum==null){
		pageNum="1";//pageNum에 아무런 값이 없으면 1부터 시작
	}
	
	//선택한 페이지 번호 숫자로 변경
	int currentPage = Integer.parseInt(pageNum);
	//currentPage가 1일 경우 1
	int startRow = (currentPage-1)*pageSize+1;
	//currentPage가 1일 경우 5
	int endRow = currentPage * pageSize;
	
	BoardDao bdao = BoardDao.getInstance();
	
	ArrayList<BoardBean> lists = null;
	int count = bdao.getArticleCount();
	if(count > 0) {
		//startRow와 endRow를 넘겨 5개만 가져오기
		lists = bdao.getArticles(startRow,endRow);
	}
%>

<h4>글목록(전체 글 : <%=count %>)</h4>

<table id="write">
	<tr>
		<td align="right" bgcolor="<%=value_c%>">
			<a href="writeForm.jsp">글쓰기</a>
		</td>
	</tr>
</table><br>
<%
	if(count == 0){
%>
<table id="write">
	<tr>
		<td align="center" bgcolor="<%=value_c%>">
			게시판에 저장된 글이 없습니다.
		</td>
	</tr>
</table><br>
<%
	} else{
%>
		<table border="1" id="list">
			<tr height="30" bgcolor="<%=title_c %>">
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회</th>
				<th>IP</th>
			</tr>
		<%for(BoardBean bb : lists){ %>
				<tr height="30" align="center" bgcolor="<%=value_c%>">
					<td><%=bb.getNum() %></td> 
					<td align="left" style="padding-left:20px">
						<%
							int wid = 20;
							if(bb.getRe_level() > 0){ //만약 답글이면
								wid = 20 * bb.getRe_level();
						%>
							<img src="images/level.gif" width="<%=wid%>" height="20px">
							<img src="images/re.gif">
						<%
							}
						%>
						<a href="content.jsp?num=<%=bb.getNum() %>&pageNum=<%=pageNum%>"><%=bb.getSubject() %></a>
						<%
							if(bb.getReadcount()>= 10){ //만약 조회수가 10이상
						%>
							<img src="images/hot.gif" height="20px">
						<%
							}
						%>
					</td>
					<td><%=bb.getWriter() %></td>
					<td><%=sdf.format(bb.getReg_date()) %></td>
					<td><%=bb.getReadcount() %></td>
					<td><%=bb.getIp() %></td>
				</tr>
			<%}//for %>
</table>
<%
	}//else
	if(count>0){
		//pageCount :  필요한 페이지 갯수
		//23 / 5 => 4 + (나머지가 0이면 0 아니면 1)
		int pageCount = count / pageSize + (count%pageSize==0? 0 : 1);
		int pageBlock = 3; //페이지 버튼 한번에 3개씩만 보이도록
		
		//1페이지 : ( 0 / 3 * 3 ) + 1 => 0*3+1=>1 | 1+3-1 =>3
		//3페이지 : 3 | 5
		//8페이지 : ( 7 / 3 * 3 ) + 1 => 2*3+1=>7 | 9
		int startPage = ((currentPage-1) / pageBlock * pageBlock)+1;
		int endPage = startPage + pageBlock-1;
		
		//레코드 갯수 : 37 | 필요한 페이지 갯수 : 8
		//공식대로라면 [7][8][9]=>불가능 [7][8]이 되도록 if문 사용
		//필요한 페이지 갯수가 마지막 페이지보다 작다면,
		//마지막 페이지 변수에 필요한 페이지 갯수 값을 저장
		if( pageCount < endPage ){
			endPage = pageCount;
		}//if
		
		//1 2 3
		//4 5 6
		//7 8 9
		//시작페이지가 3보다 클 때,이전을 누르면 3페이지 적은 곳으로 이동
		if(startPage >3){
%>
			<a href="select.jsp?pageNum=<%=startPage-3%>">[이전]</a>
<%
		}//if
		
		for(int i=startPage;i<=endPage;i++){
%>
			<a href="select.jsp?pageNum=<%=i %>">[<%=i %>]</a>
<%
		}//for
		
		//다음페이지 버튼
		if(endPage < pageCount){
%>
		<a href="select.jsp?pageNum=<%=startPage+3%>">[다음]</a>
<%		
		}//if
		
	}//if
%>
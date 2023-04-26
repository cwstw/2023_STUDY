<%@page import="myPkg.MovieBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="myPkg.MovieDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
movieList.jsp<br>
<script type="text/javascript">
	function selectDelete(){
		var ck=document.getElementsByName("rowcheck")
 		
		flag= false;
		for(i=0;i<ck.length;i++){
			if(ck[i].checked){
				flag=true;
			}
		}
		
		if(!flag){
			alert('삭제할 체크박스 하나라도 선택하세요');
			return;
		}
		
		document.myform.submit();
	}
	
	function allselect(obj) {
		var rowch = document.getElementsByName("rowcheck");
		
		if(obj.checked){
			for(i=0; i<rowch.length; i++){
				rowch[i].checked = true;
			}
		}else{
			for(i=0; i<rowch.length; i++){
				rowch[i].checked = false;
			}
		}
	}
	
</script>
<!-- myPkg.MovieDao mdao = new myPkg.MovieDao() -->
<%-- <jsp:useBean id="mdao" class="myPkg.MovieDao"/> --%>
<% 
	MovieDao mdao = MovieDao.getInstance();	
	System.out.println("select.jsp mdao:" + mdao);

	request.setCharacterEncoding("utf-8");
	String[] title = {"번호","아이디","이름","나이","좋아하는 장르","즐겨보는 시간대","동반관객수","개선사항","수정","삭제"};
	ArrayList<MovieBean> lists = mdao.getAllMovie(); 
%>

<form name = "myform" action="deleteAll.jsp" method="post">
	<input type="button" value="추가" onClick="location.href='insertForm.jsp'">
	<input type="button" value="삭제" onClick="return selectDelete()">
	<table border = "1" width = "100%">
		<tr style="background-color : yellow">
			<th>
				<input type="checkbox" name="allcheck" onClick="allselect(this)"></th>
			<% for(int i=0;i<title.length;i++){%>
				<th><%=title[i] %> </th>
			<%} %>
		</tr>
		
		<% for(MovieBean mb : lists){ %>
		<tr>
			<td><input type="checkbox" name="rowcheck" value="<%=mb.getNum() %>"></td>
			<td><%=mb.getNum() %></td>
			<td><%=mb.getId() %></td>
			<td><%=mb.getName() %></td>
			<td><%=mb.getAge() %></td>
			<td><%=mb.getGenre() %></td>
			<td><%=mb.getTime() %></td>
			<td><%=mb.getPartner() %></td>
			<td><%=mb.getMemo() %></td>
			<td><a href="updateForm.jsp?num=<%=mb.getNum()%>">수정</a></td>
			<td><a href="deleteProc.jsp?num=<%=mb.getNum()%>">삭제</a></td>
		</tr>
		<%} %>

	</table>
</form>
<%@page import="myPkg.MovieBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="myPkg.MovieDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	request.setAttribute("flag","false"); 
	MovieDao mdao = MovieDao.getInstance();	
	System.out.println("select.jsp mdao:" + mdao);

	request.setCharacterEncoding("utf-8");
	String[] title = {"번호","아이디","이름","나이","좋아하는 장르","즐겨보는 시간대","동반관객수","개선사항","수정","삭제"};
	ArrayList<MovieBean> lists = mdao.getAllMovie(); 
%>

<form name = "myform" action="deleteAll.mv" method="post">
	<input type="button" value="추가" onClick="location.href='insertForm.jsp'">
	<input type="button" value="삭제" onClick="return selectDelete()">
	<table border = "1" width = "100%">
		<tr style="background-color : yellow">
			<th>
				<input type="checkbox" name="allcheck" onClick="allselect(this)"></th>
			<c:set var="title" value="<%=title%>"/>
			<c:forEach var="i" begin="0" end="${fn:length(lists)}">
				<th>${title[i]}</th>
			</c:forEach>
		</tr>
		
		<c:forEach var="mb" items="${lists[i]}">
		<tr>
			<td><input type="checkbox" name="rowcheck" value="${mb.num}"></td>
			<td>${mb.num}</td>
			<td>${mb.id}</td>
			<td>${mb.name}</td>
			<td>${mb.age}</td>
			<td>${mb.genre}</td>
			<td>${mb.time}</td>
			<td>${mb.partner}</td>
			<td>${mb.memo}</td>
			<td><a href="updateForm.mv?num=${mb.num}">수정</a></td>
			<td><a href="delete.mv?num=${mb.num}">삭제</a></td>
		</tr>
		</c:forEach>

	</table>
</form>
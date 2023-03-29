<%@page import="my.shop.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- category_input.jsp(2가지) => categoryProc.jsp -->
<%
	request.setCharacterEncoding("UTF-8");
	CategoryDAO cdao = CategoryDAO.getInstance();
%>

<!-- my.shop.CategoryBean cb = new my.shop.CategoryBean(); -->
<jsp:useBean id="cb" class="my.shop.CategoryBean"/>
<jsp:setProperty property="*" name="cb"/>

<%	
	String message = null;
	String url = null;
	
	int cnt = cdao.insertCategory(cb);  
	if(cnt != -1){
		message = "등록 성공";
		url = "category_list.jsp";
	}
	else{
		message = "등록 실패";
		url = "category_input.jsp";
	}
	
%> 

<script type="text/javascript">
	alert("<%= message %> "); 
	location.href= '<%= url %>'; 
</script>


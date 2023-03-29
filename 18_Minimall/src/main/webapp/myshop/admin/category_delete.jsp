<%@page import="my.shop.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
category_list.jsp(삭제클릭 cnum=번호)=>category_delete.jsp

<!-- cdao.deleteCategory(num)

alert(성공/실패)

category_list.jsp 이동
 -->

<%
	String cnum = request.getParameter("cnum");

	CategoryDAO cdao = CategoryDAO.getInstance();

	int cnt = cdao.deleteCategory(cnum); 
	
	String msg, url;
	
	if(cnt == 1){
		msg = "delete 성공";
	}else{
		msg = "delete 실패";
	}
	url = "category_list.jsp";
%>

<script type="text/javascript">
	alert("<%=msg %>");
	location.href="<%=url%>";
</script>



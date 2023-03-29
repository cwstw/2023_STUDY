<%@page import="com.oreilly.servlet.MultipartRequest;"%>
<%@page import="my.shop.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="pb" class="my.shop.ProductBean"/>
<jsp:setProperty property="*" name="pb"/>
<%
	//request.setCharacterEncoding("utf-8");
	//String pname = request.getParameter("pname");
	//out.println("pname : "+pname);
	String configFolder = config.getServletContext().getRealPath("/myshop/images");
	System.out.println("configFolder : "+configFolder);
	
	String requestFolder = request.getContextPath()+"/myshop/images";
	System.out.println("requestFolder : "+requestFolder);

	String url,msg;
	try{
	int maxsize = 1024*1024*5;
	String encoding = "UTF-8";
	MultipartRequest mr = new MultipartRequest(request,
											configFolder,
											maxsize,
											encoding,
											new DefaultFileRenamepolicy());
	
	System.out.println(mr.getPrameter("pname"));
	System.out.println(mr.getPrameter("pimage"));
	System.out.println(mr.getFilesystemName("pimage"));
	
	ProductDAO pdao = ProductDAO.getInstance();
	int cnt = pdao.insertProduct(mr); 
	
	
	if(cnt > 0){
		url="product_list.jsp";
		msg="상품 등록 성공";
	}else{
		url="product_input.jsp";
		msg="상품 등록 실패";	
	}
	} catch(Exception e) {
		msg="가격, 수량은 숫자로 입력하세요.";
	}
%>
<script>
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
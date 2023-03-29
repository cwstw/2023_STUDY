<%@page import="my.shop.ProductDAO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
productProc.jsp<br>

<%
	//request.setCharacterEncoding("UTF-8");
	//String pname = request.getParameter("pname");
	//out.println("pname:" + pname);
	String configFolder = config.getServletContext().getRealPath("/myshop/images/");
	System.out.println("configFolder:" + configFolder);
	//configFolder:C:\JSP_ysy\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\18_Minimall\

	String requestFolder = request.getContextPath()+"/myshop/images/";
	System.out.println("requestFolder:" + requestFolder);
	//requestFolder:/18_Minimall
	
	int maxSize = 1024*1024*5;
	String encoding="UTF-8";
	
	String msg, url;
	try{
		MultipartRequest mr = new MultipartRequest(request,
											configFolder,
											maxSize,
											encoding,
											new DefaultFileRenamePolicy());
		
		System.out.println(mr.getParameter("pname"));
		System.out.println(mr.getParameter("pimage")); // null
		System.out.println(mr.getFilesystemName("pimage")); // 검정양복1.jpg
		System.out.println(mr.getOriginalFileName("pimage")); 
		
		ProductDAO pdao = ProductDAO.getInstance();
		int cnt = pdao.insertProduct(mr);  
		if(cnt >0){
			msg = "상품 등록 성공";
			url = "product_list.jsp";
		}else{
			msg = "상품 등록 실패";
			url = "product_input.jsp";
		}
	}catch(Exception e){
		msg = "가격, 수량은 숫자로 입력하세요";
		url = "product_input.jsp";
	}
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>









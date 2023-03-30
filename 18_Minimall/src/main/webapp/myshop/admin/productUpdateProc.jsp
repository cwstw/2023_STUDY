<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="my.shop.ProductDAO"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	int maxsize = 1024*1024*5;
	
	String configFolder = config.getServletContext().getRealPath("/myshop/images");
	
	MultipartRequest mr = new MultipartRequest(request,
												configFolder,
												maxsize,
												"utf-8",
												new DefaultFileRenamePolicy()
												);
	String pnum = mr.getParameter("pnum");
	String pname = mr.getParameter("pname");
	String pcategory_fk = mr.getParameter("pcategory_fk");
	
	String pimageold = mr.getParameter("pimageold");
	//글자가 넘어오기 때문에 파일이 아니라 파라미터로 넘겨 받음
	// 파일은 아래처럼.
	String pimage = mr.getFilesystemName("pimage");
	
	String img = null;
	if(pimageold ==null){
		if(pimage!=null){ //orig x, new o
			img = pimage; //없없는데 새로운 이미지 등록
		}//if
	}else if(pimageold!=null){
		if(pimage == null){ //orig o, new x
			img = pimageold; //기존으로 그대로 사용
		}else{// orig o, new o
			img = pimage; //있었는데 새 이미지 등록
			//웹서버 경로의 기존 이미지 삭제
			File delFile = new File(configFolder, pimageold);
			delFile.delete(); //삭제
		}//else
	}//else if

	ProductDAO pdao = ProductDAO.getInstance();
	int cnt = pdao.updateProduct(mr, img);
	
	String msg="",url="";
	if(cnt > 0){
		msg="수정 성공";
		url="product_list.jsp";
	}else{		
		msg="수정 실패";
		url="product_update.jsp?pnum="+pnum;
	}
%>
<script>
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>

<!-- 
orig O, new O
orig X, new O
orig O, new X
orig X, new X
 -->
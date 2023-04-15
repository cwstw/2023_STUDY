<%@page import="ARTSHOP.MEMBER.MEMBERDAO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- AD_MEMBERUP_PROC.jsp -->
<%
	request.setCharacterEncoding("UTF-8");
	String memnum = request.getParameter("memnum");
	MEMBERDAO mdao = MEMBERDAO.getInstance();
%>
<jsp:useBean id="mdto" class="ARTSHOP.MEMBER.MEMBERDTO"/>
<jsp:setProperty property="*" name="mdto"/>
<%
	String configFolder = config.getServletContext().getRealPath("/MYARTSHOP/IMAGES/");
	System.out.println("configFolder:" + configFolder);
	
	String requestFolder = request.getContextPath()+"/MYARTSHOP/IMAGES/";
	System.out.println("requestFolder:" + requestFolder);
	
	int maxSize = 1024*1024*5;
	//System.out.println("maxsize:" + maxSize);
	String encoding="UTF-8";
	//System.out.println("encoding:" + encoding);
	
	
	String msg="", url="";
	try{
		MultipartRequest mr = new MultipartRequest(request,
											configFolder,
											maxSize,
											encoding,
											new DefaultFileRenamePolicy());
		//System.out.println("mr : "+mr);
		
		/* 
		System.out.println(mr.getParameter("pimage")); // null
		System.out.println(mr.getFilesystemName("pimage")); // ~.jpg
		System.out.println(mr.getOriginalFileName("pimage"));  */
		
		int cnt = mdao.updateMember(mr, memnum); 
		//System.out.println("cnt : "+cnt);
		
		if(cnt >0){
			msg = "수정 완료!";
			url = "AD_MEMBERLIST.jsp";
		}else{
			msg = "수정 실패!01";
			url = "AD_MEMBERLIST.jsp";
		}//else
	}catch(Exception e){
		msg = "수정 실패!02";
		url = "AD_MEMBERLIST.jsp";
	}//catch
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
%>
<%@page import="ARTSHOP.MEMBER.MEMBERDAO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- REGISTER_PROC.jsp -->
<%
	request.setCharacterEncoding("UTF-8");
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
		
		int cnt = mdao.insertMember(mr);   
		//System.out.println("cnt : "+cnt);
		
		if(cnt >0){
			if(mr.getParameter("memkind").equals("일반")){
			msg = mr.getParameter("memnick")+"님 환영합니다! 이제 상상을 현실로 바꿀 시간이에요!";
			}else if(mr.getParameter("memkind").equals("작가")){
			msg = mr.getParameter("memnick")+"님 환영합니다! 누군가의 상상을 실현하는 마법사가 되셨네요!";
			}
			url = "LOGIN.jsp";
		}else{
			msg = "가입 실패!😢 빠뜨린 부분이 없는지 살펴보시겠어요?";
			url = "REGISTER.jsp";
		}//else
	}catch(Exception e){
		msg = "가입 실패!😢 잘못 입력한 부분이 있는 것 같아요!";
		url = "REGISTER.jsp";
	}//catch
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
%>
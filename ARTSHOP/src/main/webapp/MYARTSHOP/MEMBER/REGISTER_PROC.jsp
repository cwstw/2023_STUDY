<%@page import="ARTSHOP.MEMBER.MEMBERDAO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- REGISTER_PROC.jsp -->
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="mdto" class="ARTSHOP.MEMBER.MEMBERDTO"/>
<jsp:setProperty property="*" name="mdto"/>
<%
	String configFolder = config.getServletContext().getRealPath("/MYARTSHOP/IMAGES/");
	System.out.println("configFolder:" + configFolder);
	
	String requestFolder = request.getContextPath()+"/MYARTSHOP/IMAGES/";
	System.out.println("requestFolder:" + requestFolder);
	
	int maxSize = 1024*1024*5;
	String encoding="UTF-8";
	
	String msg, url;
	try{
		MultipartRequest mr = new MultipartRequest(request,
											configFolder,
											maxSize,
											encoding,
											new DefaultFileRenamePolicy());
		/* 
		System.out.println(mr.getParameter("pname"));
		System.out.println(mr.getParameter("pimage")); // null
		System.out.println(mr.getFilesystemName("pimage")); // ~.jpg
		System.out.println(mr.getOriginalFileName("pimage"));  */
		
		MEMBERDAO mdao = MEMBERDAO.getInstance();
		int cnt = mdao.insertMember(mr);  
		if(cnt >0){
			if(mdto.getMemkind().equals("일반")){
			msg = mdto.getMemnick()+"님 환영합니다! 이제 상상을 현실로 바꿀 시간이에요!";
			}else if(mdto.getMemkind().equals("작가")){
			msg = mdto.getMemnick()+"님 환영합니다! 누군가의 상상을 실현하는 마법사가 되셨네요!";
			}
			url = "LOGIN.jsp";
		}else{
			msg = "가입 실패!😢 빠뜨린 부분이 없는지 살펴보시겠어요?";
			%>
			<script type="text/javascript">
				location.history(-1);
			</script>
			<%
		}//else
	}catch(Exception e){
		msg = "가입 실패!😢 잘못 입력한 부분이 있는 것 같아요!";
		%>
		<script type="text/javascript">
			location.history(-1);
		</script>
		<%
	}//catch
%>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="<%=url%>";
</script>
%>
<%@page import="java.io.File"%>
<%@page import="ARTSHOP.MEMBER.MEMBERDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- AD_MEMBERDEL.jsp -->
<%
	String memnum = request.getParameter("memnum");
	String mempic = request.getParameter("mempic");
	MEMBERDAO pdao = MEMBERDAO.getInstance();
	
	String configFolder = config.getServletContext().getRealPath("/MYARTSHOP/IMAGES/");
	
	File delFile = null;
	File dir = new File(configFolder);
	//경로가 담긴 문자열을 파일객체로 만들기=>문자열이 폴더 개념으로 바뀜
	if(mempic != null){
		delFile = new File(dir, mempic); //해당 폴더 밑에 있는 파일로 인식
		if(delFile.exists()){//delfile이 존재하면
			if(delFile.delete()){//지우는 걸 성공하면
			%>
				<script>
					alert("이미지 파일 삭제 성공");
				</script>
			<%
			}//if
		}//if
	}//if
			
	int cnt = pdao.deleteMember(memnum);  
	String msg="";
	
	if(cnt > 0){
		msg="삭제 성공";
	} else{
		msg="삭제 실패";
	}
%>
<script>
	alert("<%=msg%>");
	location.href="AD_MEMBERLIST.jsp";
</script>
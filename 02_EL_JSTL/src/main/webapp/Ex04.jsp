<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
Ex04.jsp<br>

<%
	int age = 20;
	out.print("age : "+age+"<br>");
	application.setAttribute("a_age",age);//실행하면 설정 완료
%>
<%=application.getInitParameter("myname")%>
<%=application.getInitParameter("mybirth")%>
<ul>
<%
Enumeration<String> initEnum = application.getInitParameterNames();
while(initEnum.hasMoreElements()){
	String pName = initEnum.nextElements();
	%>
	<li><%=pName %> : <%=application.getInitParameter(pName)%></li>
	<%
}
%>
</ul>

<br><br>
저의 이름은 ${initParam.myname}이고
제 생일은 ${initParam.mybirth}입니다.

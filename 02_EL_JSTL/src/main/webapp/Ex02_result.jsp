<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="pb" class="myPkg.PersonBean"/>
<jsp:setProperty property="*" name="pb"/>

[출력1]
아이디 : <%=request.getParameter("id") %><br>
비밀번호 : <%=request.getParameter("password") %><br>
이름 : <%=request.getParameter("name") %><br>
나이 : <%=request.getParameter("age") %><br>

[출력2]
아이디 : <%=pb.getId() %><br>
비밀번호 : <%=pb.getPassword() %><br>
이름 : <%=pb.getName() %><br>
나이 : <%=pb.getAge() %><br>

[출력3]
아이디 : <jsp:getProperty name="pb" property="id"/><br>
비밀번호 : <jsp:getProperty name="pb" property="password"/><br>
이름 : <jsp:getProperty name="pb" property="name"/><br>
나이 : <jsp:getProperty name="pb" property="age"/><br>

[출력4]
아이디 : ${param.id }<br>
비밀번호 : ${param["password"] }<br>
이름 : ${param['name'] }<br>
나이 : ${param[age] }<br> <!-- 따옴표 없으면 공백 -->

[출력5]
아이디 : ${pb.id }<br>
비밀번호 : ${pb.password }<br>
이름 : ${pb.name }<br>
나이 : ${pb.age }<br> <!-- 따옴표 없으면 공백 -->

<hr>

id비교
아이디 : <%=request.getParameter("id")=="hong" %><br>
아이디 : <%=request.getParameter("id").equals("hong") %><br>
아이디 : ${param.id == "hong" }<br>
아이디 : ${param.id eq "hong" }<br>
아이디 : ${param.id.equals("hong")                                                                                                                                                                                                                }<br>




<!-- jsp 내장 객체 : session/config/response/out/application -->
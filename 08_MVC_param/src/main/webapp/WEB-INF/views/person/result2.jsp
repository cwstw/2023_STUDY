<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result2.jsp<br>

id1 : <%=request.getParameter("id") %>
id2 : ${param.id}
id3 : ${id}

passwd1 : <%=request.getParameter("passwd") %>
passwd2 : ${param.passwd}
passwd3 : ${passwd}

addr1 : <%=request.getParameter("addr") %>
addr2 : ${param.addr}
addr3 : ${addr}

pb.id : ${pb.id}
pb.passwd : ${pb.passwd}
pb.addr : ${pb.addr}
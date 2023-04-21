<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
Ex_result_탁민지.jsp<br>
<%
	request.setCharacterEncoding("UTF-8");
%>
[param]<br>
<table border=1>
	<tr>
		<td>제목</td>
		<td>${param.title}</td>
	</tr>
	<tr>
		<td>저자</td>
		<td>${param.author}</td>
	</tr>
	<tr>
		<td>출판사</td>
		<td>${param.publisher}</td>
	</tr>
	<tr>
		<td>가격</td>
		<td>
		${param.price}
		</td>
	</tr>
	<tr>
		<td>입고일</td>
		<td>${param.buy}</td>
	</tr>
	<tr>
		<td>배송비</td>
		<td>
			<c:if test="${param.kind==null}">
				배송비 체크 누락
			</c:if>
			<c:if test="${not (param.kind==null)}">
				${param.kind}	
			</c:if>
		</td>
	</tr>
	<tr>
		<td>구입가능 서점</td>
		<td>
			<c:if test="${paramValues.bookstore==null}">
				구입가능 서점 체크 누락
			</c:if>
			<c:if test="${not (paramValues.bookstore==null)}">
				<c:forEach var="bs" items="${paramValues.bookstore}">
					${bs} 
				</c:forEach>
			</c:if>
		</td>
	</tr>
	<tr>
		<td>보유수량</td>
		<td>
			<c:if test="${param.count=='선택'}">
				보유수량 체크 누락
			</c:if>
			<c:if test="${not (param.count=='선택')}">
				${param.count}	
			</c:if>
		</td>
	</tr>
</table>
<br>
[jsp]<br>
<jsp:useBean id="bb" class="myPkg.BookBean"/>
<jsp:setProperty property="*" name="bb"/>
<table border=1>
	<tr>
		<td>제목</td>
		<td>${bb.title}</td>
	</tr>
	<tr>
		<td>저자</td>
		<td>${bb.author}</td>
	</tr>
	<tr>
		<td>출판사</td>
		<td>${bb.publisher}</td>
	</tr>
	<tr>
		<td>가격</td>
		<td>
		${bb.price}
		</td>
	</tr>
	<tr>
		<td>입고일</td>
		<td>${bb.buy}</td>
	</tr>
	<tr>
		<td>배송비</td>
		<td>
			<c:if test="${bb.kind==null}">
				배송비 체크 누락
			</c:if>
			<c:if test="${not (bb.kind==null)}">
				${bb.kind}	
			</c:if>
		</td>
	</tr>
	<tr>
		<td>구입가능 서점</td>
		<td>
			<c:if test="${bb.bookstore==null}">
				구입가능 서점 체크 누락
			</c:if>
			<c:if test="${not (bb.bookstore==null)}">
				<c:forEach var="i" begin="0" end="${fn:length(bb.bookstore)-1}">
					${bb.bookstore[i]}
				</c:forEach>
			</c:if>
		</td>
	</tr>
	<tr>
		<td>보유수량</td>
		<td>
			<c:if test="${bb.count=='선택'}">
				보유수량 체크 누락
			</c:if>
			<c:if test="${not (bb.count=='선택')}">
				${bb.count}	
			</c:if>
		</td>
	</tr>
</table>
<br><br>
[jstl]<br>
<c:set var="bk" value='<%=new myPkg.BookBean() %>'/>
<c:set target="${bk}" property="title" value="${param.title}"/>
<table border=1>
	<tr>
		<td>제목</td>
		<td>${bk.title}</td>
	</tr>
	<tr>
		<td>저자</td>
		<td>${bk.author}</td>
	</tr>
	<tr>
		<td>출판사</td>
		<td>${bk.publisher}</td>
	</tr>
	<tr>
		<td>가격</td>
		<td>
		${bk.price}
		</td>
	</tr>
	<tr>
		<td>입고일</td>
		<td>${bk.buy}</td>
	</tr>
	<tr>
		<td>배송비</td>
		<td>
			<c:if test="${bk.kind==null}">
				배송비 체크 누락
			</c:if>
			<c:if test="${not (bk.kind==null)}">
				${bk.kind}	
			</c:if>
		</td>
	</tr>
	<tr>
		<td>구입가능 서점</td>
		<td>
			<c:if test="${bk.bookstore==null}">
				구입가능 서점 체크 누락
			</c:if>
			<c:if test="${not (bk.bookstore==null)}">
				<c:forEach var="bs" items="${bk.bookstore}">
					${bs} 
				</c:forEach>
			</c:if>
		</td>
	</tr>
	<tr>
		<td>보유수량</td>
		<td>
			<c:if test="${bk.count=='선택'}">
				보유수량 체크 누락
			</c:if>
			<c:if test="${not (bk.count=='선택')}">
				${bk.count}	
			</c:if>
		</td>
	</tr>
</table>



param jsp jstl
배송비 서점 수량 누락시 체크누락 표시
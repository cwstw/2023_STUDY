<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
result2.jsp<br>

제목 : ${bookBean.title}
저자 : ${bookBean.author}
가격 : ${bookBean.price }
출판사 : ${bookBean.publisher }
구입가능서점1 :
<c:forEach var="bs" items="${bookBean.bookstore}"  varStatus="st">
	${bs}
	<c:if test="${not st.last}">,</c:if>
</c:forEach>
구입가능서점2 : ${bookBean.bookstore}
배송비 : ${bookBean.kind}
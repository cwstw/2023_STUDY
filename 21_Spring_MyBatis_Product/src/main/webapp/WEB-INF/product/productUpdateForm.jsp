<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>

<center>

<h2>상품 수정화면(productUpdateForm.jsp) ${pb.num}</h2>

<form:form commandName="productBean" action="update.prd" method="post" enctype="multipart/form-data">
<input type="hidden" name="pageNumber" value="${pageNumeber}">
<input type="hidden" name="num" value="${pb.num}">
	<table border="1">
		<tr>
			<td>*상품명</td>
			<td><input type="text" name="name" value="${pb.name}">
			<form:errors cssClass="err" path="name"/></td>
		</tr>
		<tr>
			<td>제조회사</td>
			<td><input type="text" name="company" value="${pb.company}"></td>
		</tr>
		<tr>
			<td>*가격</td>
			<td><input type="text" name="price" value="${pb.price}">
			<form:errors cssClass="err" path="price"/></td>
		</tr>
		<tr>
			<td>재고수량</td>
			<td><input type="text" name="stock" value="${pb.stock}"></td>
		</tr>
		<tr>
			<td>적립포인트</td>
			<td><input type="text" name="point" value="${pb.point}"></td>
		</tr>
		<tr>
			<td>*설명</td>
			<td><input type="text" name="contents" value="${pb.contents}">
			<form:errors cssClass="err" path="contents"/></td>
		</tr>
		<tr>
			<td>*그림파일</td>
			<td>
			<img src="<%=request.getContextPath() %>/resources/${pb.image}" alt="productimage" width="100" height="100">
			<input type="file" name="upload" value="${pb.upload}">
			<!-- 기본이미지 삭제 후 새 이미지를 넣어주기 위해 숨겨서 넘김 -->
			<input type="hidden" name="upload2" value="${pb.image}">
			<form:errors cssClass="err" path="image"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="수정하기"></td>
		</tr>
	</table>
</form:form>
</center>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
list.jsp<br>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script>
/* $(document).ready(function() {
	$("#allcheck").click(function() {
		if($("#allcheck").is(":checked")) $("input[name=check]").prop("checked", true);
		else $("input[name=check]").prop("checked", false);
	});
	
	$("input[name=check]").click(function() {
		var total = $("input[name=check]").length;
		var checked = $("input[name=check]:checked").length;
		
		if(total != checked) $("#allcheck").prop("checked", false);
		else $("#allcheck").prop("checked", true); 
	});
}); */

function All(){
	var check = document.myform.allcheck.checked;
	
	var checkNum = document.getElemnetByName("rowCheck");
	if(check){
		for(i=0;i<checkNum.length;i++){
			checkNum[i].checked = true;
		}
	}else{
		checkNum[i].checked = false;
	}//if
}//all

function selectChk(){
	
	var num = document.getElementByNum('rowCheck');//rowCheck가 여러개라 3개짜리 배열이 됨
	var flag = false;
	
	for(var i=0;i<num.length;i++){
		if(num[i].checked){//체크가 되었다면
			flag = true;
		}
	}
	if(!flag){
		alert('하나라도 선택하세요');
		return false;
	}
	myform.submit(); //action으로 이동
}

</script>
<form name="myform" action="deleteMulti">
<table border="1">
	<tr>
		<td><input type="checkbox" name="allcheck" value="allcheck" onClick="All()"></td>
		<!-- <td><input type="checkbox" name="check" value="allcheck" id="allcheck"></td> -->
		<td>번호</td>
		<td>아이디</td>
		<td>패스워드</td>
		<td>구매상품</td>
		<td>배송시간</td>
		<td>결제방법</td>
		<td>결제동의</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
	<c:forEach var="ml" items="${lists}" varStatus="st">
	<tr>
		<td><input type="checkbox" name="rowCheck" value="${ml.num}"></td> <!-- 선택하면 rowcheck에 선택한 번호 담김 -->
		<td>${ml.num}</td>
		<td>${ml.id}</td>
		<td>${ml.pw}</td>
		<td>${ml.product}</td>
		<td>${ml.time}</td>
		<td>${ml.approve}</td>
		<td>${ml.agree}</td>
		<td><a href="updateForm?num='${ml.num}'">수정</a></td>
		<td><a href="delete?num='${ml.num}'">삭제</a></td>
	</tr>
	</c:forEach>
</table>
</form>
<br>
<a href="form">삽입</a>
<%-- <a href="deleteAll?num=${mDto.num}">삭제</a> --%>
<input type="button" value="삭제" onClick="selectChk()">

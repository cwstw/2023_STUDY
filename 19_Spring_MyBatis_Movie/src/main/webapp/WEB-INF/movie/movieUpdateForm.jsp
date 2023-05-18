<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>
<script>
	var f_selbox = new Array('아시아','아프리카','유럽','아메리카','오세아니아');
	
	var s_selbox = new Array(); //2차월 배열
	s_selbox[0] = new Array('한국','중국','베트남','네팔');
	s_selbox[1] = new Array('케냐', '가나', '세네갈');
	s_selbox[2] = new Array('스페인', '영국','덴마크','러시아','체코');
	s_selbox[3] = new Array('미국', '캐나다'); 
	s_selbox[4] = new Array('뉴질랜드','오스트레일리아');

	//대륙
	//body로드 시 가장 먼저 호출(myform의 정보를 매개변수로 받음)
	function init(f){ 
		
		//0번방에는 이미 있으므로 1번(i+1)부터 시작
		for(var i=0;i<f_selbox.length;i++){
			f.continent.options[i+1] = new Option(f_selbox[i]);
		}//for
	}//init
	
	//나라
	//대륙이 바뀌면 호출(myform의 정보를 매개변수로 받음)
	function firstChange(f){
		var sel_index = f.continent.selectedIndex;
		var sel_val = f.continent[sel_index].value;
		
		//alert(sel_index+","+sel_val);

		//선택된 기존 나라 옵션 지우기
		//없앨 때는 뒤에부터!(앞에 삭제 시 하나씩 당겨지기 때문)
		for(i=f.nation.length; i>0 ;i--){
			f.nation.options[i] = null;
		}
		
		//선택된 인덱스-1(대륙 0번 제외, 나라 0부터)
		for(var i=0; i<s_selbox[sel_index-1].length; i++){
			f.nation.options[i+1] = new Option(s_selbox[sel_index-1][i]);
		}
	}//firstchange
	

</script>
<style>
	.err{
		color: red;
		font-size: 9px;
		font-weight: bold;
	}
</style>

<!-- movieInsertForm.jsp<br> -->
<body onLoad="init(myform)">
<!-- movieUpdateForm.jsp -->

<center>
<h2>영화 수정 화면</h2>
<form:form commandName="movie" name="myform" action="insert.mv" method="post">
<input type="hidden" name="num" value="${mv.num }">
 <table boder="1">
 	<tr>
 		<td>
		  <label for="title">영화 제목</label>
		</td>
		<td>
		  <input type="text" name="title" id="title" value="${mv.title }">
		  <form:errors cssClass="err" path="title"/>
		</td>
	</tr>
	<tr>
		<td>
		  <label for="continent">대륙</label>
		</td>
		  <select name ="continent" id="first" onchange="firstChange(myform)">
				<option value="" >대륙 선택하세요</option>
			</select>
		  <form:errors cssClass="err" path="continent"/>
	</tr>
	<tr>
		<td>
	  		<label for="nation">나라-</label>
	  	</tr>
	  	<td>
	  		<select name ="nation" id="second">
			<option value="" >나라 선택하세요</option>
			</select>
	  		<form:errors cssClass="err" path="nation"/>
	  	</td>
	  	<tr>
	  		<td>
			  <label for="genre">장르 : </label>
	  		</td>
	  		<td>
			  <c:forEach var="genre" items="액션,스릴러,코미디,판타지,애니메이션">
			  <input type="checkbox" name="genre" id="genre" value="${ genre }" <c:if test="${ fn:contains(movieBean.genre, genre) }">checked</c:if>>${ genre }
			  </c:forEach><br>
			  <form:errors cssClass="err" path="genre"/>
	  		</td>
	  	</tr>
		<tr>
			<td>
			  <label for="grade">등급 : </label>
			</td>
			<td>
			  <c:forEach var="grade" items="19,15,12,7">
			    <input type="radio" name="grade" id="grade" value="${ grade }" <c:if test="${ fn:contains(movieBean.grade, grade) }">checked</c:if>>${ grade }
			  </c:forEach><br>
			  <form:errors cssClass="err" path="grade"/>
			</td>
		</tr>
		<tr>
			<td>
			  <label for="actor">출연 배우 : </label>
			</td>
			<td>
			  <input type="text" name="actor" id="actor" value="${ mv.actor }">
			  <form:errors cssClass="err" path="actor"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			  <input type="submit" value="수정하기">
			</td>
		</tr>
 </table>
</form:form>
</center>
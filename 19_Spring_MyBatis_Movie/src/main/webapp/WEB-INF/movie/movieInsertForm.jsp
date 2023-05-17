<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../common/common.jsp" %>
<script type="text/javascript" src="../../resources/js/jquery.js"></script>
<script>
	var f_selbox = new Array('아시아','아프리카','유럽','아메리카','오세아니아');
	
	var s_selbox = new Array(); //2차월 배열
	s_selbox[0] = new Array('한국','중국','베트남','네팔');
	s_selbox[1] = new Array('케냐', '가나', '세네갈');
	s_selbox[2] = new Array('스페인', '영국','덴마크','러시아','체코');
	s_selbox[3] = new Array('미국', '캐나다'); 
	s_selbox[4] = new Array('뉴질랜드','오스트레일리아');
	
/* 	$(function(){
		$('#sel_continent').change(function(){
			var v = $(this).val();
			for(i=0;i<f_selbox.length;i++){
				if(v == f_selbox[i]){
					$('#sel_nation').attr('value',s_selbox[i]);
				}//if
			}//for
		}).change();//change 강제 호출
	});//ready */
	
	
	//ex : 아시아 선택(f_selbox[0], options[1])
	//  =>sel_index = 선택된 대륙 인덱스(1)
	//  =>sel_val = 선택된 대륙 인덱스의 해당 값(아시아)
	//  =>s_selbox의 대륙인덱스값-1한 방의 길이만큼 반복(s_selbox[0]길이)
	//  =>나라 옵션+1(선택제외)에 0~대륙인덱스값-1에 s_selbox[0]번 방의 값을 반복 저장
	
	
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
	
	//중복체크
	$(document).ready(function(){
		//alert(1);
		
		var isCheck = false;
		var use;
		
		$('#title_check').click(function(){
			//alert(2);
			
			isCheck = true;
			
			$.ajax({
				url : "title_check_proc.mv",
				data : ({
						inputtitle : $('input[name = title]').val()	
				}),
				success : function(data){
					alert('data:' + data+","+data.length);
					
					if($("input[name=title]").val() ==""){
						//alert("제목 누락 되어있습니다.");
						//use = "missing";
						//$('#titlemessage').show();
						$('#titleMessage').html("<font color=green>입력 누락되었습니다.</font>");
						$('#titleMessage').show();
						
					} else if(data == 'YES'){
						$('#titleMessage').html("<font color = 'blue'>사용가능합니다</font>");
						$('#titleMessage').show();
						use = "possible";
						
					} else{
						$('#titleMessage').html("<font color = 'red'>이미 등록한 제목입니다.</font>");
						$('#titleMessage').show();
						use = "impossible";
					}
					
				}//success
				
			}); //ajax
		}); // 중복체크 클릭
		
		$("input[name=title]").keydown(function(){ 
			$('#titleMessage').css('display','none');
		});//keydown
		
		$("#sub").click(function () { // 추가하기(submit)
			if(!isCheck){
				alert("중복체크를 먼저 해주세요");
				return false;
			}
			else if(use == "impossible"){
				alert("이미 존재하는 영화입니다");
				$('input[name=title]').select();
				return false;
			}
			else if($('input[name=title]').val() == ""){
				alert("제목을 입력하세요");
				$('input[name=title]').focus();
				return false;
			}
		}); // sub
	});
	
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
<h2>영화 정보 등록 화면</h2>

<form:form commandName="movie" name="myform" action="insert.mv" method="post">
 <p>
  <label for="title">영화 제목 : </label>
  <input type="text" name="title" id="title" value="${ mv.title }">
  <input type="button" value="중복체크" id="title_check">
  <span id="titleMessage"></span>
  <form:errors cssClass="err" path="title"/>
 </p>
 <p>
  <label for="continent">대륙 : </label>
  <%-- <input type="text" name="continent" id="continent" value="${ movieBean.continent }"> --%>
  <select name ="continent" id="first" onchange="firstChange(myform)">
		<option value="" >대륙 선택하세요</option>
	</select>
  <form:errors cssClass="err" path="continent"/>
  
  <label for="nation">나라 : </label>
  <%-- <input type="text" name="nation" id="nation" value="${ movieBean.nation }"> --%>
  <select name ="nation" id="second">
		<option value="" >나라 선택하세요</option>
	</select>
  <%-- <input type="text" name="nation" id="nation" value="${ mv.nation }"> --%>
  <form:errors cssClass="err" path="nation"/>
 </p>
 <p>
  <label for="genre">장르 : </label>
  <c:forEach var="genre" items="액션,스릴러,코미디,판타지,애니메이션">
    <input type="checkbox" name="genre" id="genre" value="${ genre }" <c:if test="${ fn:contains(movieBean.genre, genre) }">checked</c:if>>${ genre }
  </c:forEach>
  <form:errors cssClass="err" path="genre"/>
 </p>
<p>
  <label for="grade">등급 : </label>
  <c:forEach var="grade" items="19,15,12,7">
    <input type="radio" name="grade" id="grade" value="${ grade }" <c:if test="${ fn:contains(movieBean.grade, grade) }">checked</c:if>>${ grade }
  </c:forEach>
  <form:errors cssClass="err" path="grade"/>
 </p>
 <p>
  <label for="actor">출연 배우 : </label>
  <input type="text" name="actor" id="actor" value="${ mv.actor }">
  <form:errors cssClass="err" path="actor"/>
 </p>
 <p>
  <input type="submit" value="추가하기">
 </p>
</form:form>
</body>
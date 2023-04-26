<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	th{
		width:150;
	}
	td{
		width:350;
	}
</style>
<!-- ================☆style☆================== -->
<script src="./js/jquery.js"></script>
<script>
$(document).ready(function(){
	
	isBlank =  false;
	use="";
	isCheck=false;
	$('#idcheck').click(function(){//중복체크 버튼 클릭 시
		isCheck=true;
		if($('input[name=id]').val()==""){
			alert("아이디를 입력하세요.");
			isBlank = true;
			return;
		}
		
		isBlack = false;
		$.ajax({
			url : "id_check.mv",
			data : ({
					//userid 변수에 입력한 값을 담음
					userid : $('input[name=id]').val()
			}),
			success : function(data){ //data안에 proc의 no나 yes가 담김
				//alert(data);
				if($.trim(data) == "YES"){
					$("#idmsg").html("<font color=blue>사용가능</font>");
					$("#idmsg").show(); //id display none 설정 해제
					use="possible";
				}else{
					$("#idmsg").html("<font color=red>사용불가</font>");						
					$("#idmsg").show(); //id display none 설정 해제
					use="impossible";
				}
			}
		});//ajax
	});//idcheck click
	
	//아이디 자리에 키 다운 시 msg 가림
	$('input[name=id]').keydown(function(){
		$('#idmsg').css('display','none');
		
		isCheck = false; //다시 키 입력 시 중복체크 안함으로 변경
	});
	
	$('#sub').click(function(){
		if(use == "impossible"){ //중복체크 통과안됨
			alert("이미 사용 중인 아이디입니다.");
			return false;
		} else if(isCheck == false){ //중복체크 안 함
			alert("중복체크가 필요합니다.");
			return false;
		}
		if(isBlank == true){
			alert("아이디를 입력하세요.");
			return false; //액션으로 넘어가지 않음
		}
	});//sub click
		
	});//ready
</script>
<!-- ================☆script☆================== -->
<%
	String[] genre = {"공포","다큐","액션","애니메이션"};
	String[] time = {"8-10","10-12","12-14","14-16","16-18","18-20","20-22","22-24"};
%>
<h3>★MOVIE INSERT★</h3>

<form name="insert.mv" action="insertProc.jsp" method="post">
<table border="1">
	<tr>
		<th>아이디</th>
		<td>
			<input type="text" name="id">
			<input type="button" name="idcheck" value="중복체크">
			<span id="idmsg"></span>
		</td>
	</tr>
	<tr>
		<th>이름</th>
		<td><input type="text" name="name"></td>
	</tr>
	<tr>
		<th>나이</th>
		<td><input type="text" name="age"></td>
	</tr>
	<tr>
		<th>좋아하는 장르</th>
		<td>
		<%for(int i=0;i<genre.length;i++){ %>
			<input type="checkbox" name="genre" value="<%=genre[i]%>"><%=genre[i]%>
		<%} %>
		</td>
	</tr>
	<tr>
		<th>즐겨보는 시간대</th>
		<td>
			<select name="time">
				<%for(int i=0;i<time.length;i++){ %>
					<option value="<%=time[i]%>"><%=time[i] %></option>
				<%} %>
			</select>
		</td>
	</tr>
	<tr>
		<th>동반관객 수</th>
		<td>
			<%for(int i=1;i<=5;i++){ %>
				<input type="radio" name="partner" value="<%=i%>"><%=i %>
			<%} %>
		</td>
	</tr>
	<tr>
		<th>영화관 개선사항</th>
		<td>
			<textarea name="memo" rows="5" cols="30"></textarea>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		<input type="submit" id="sub" value="가입하기" onClick="return Check()">
		</td>
	</tr>
</table>
</form>
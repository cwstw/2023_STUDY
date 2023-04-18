/**
 * script.js
 */

var use;
var isCheck = false;
 

function writeSave(){ // 가입클릭
	//alert(1);
	
	if($('input[name=memid]').val() == ""){
		alert("아이디를 입력해주세요.");
		$('input[name=memid]').focus();
		return false;
	}
	if($('input[name=memnick]').val() == ""){
		alert("닉네임을 입력해주세요.");
		$('input[name=memnick]').focus();
		return false;
	}
	if($('input[name=mempw]').val()==""){
		alert("비밀번호를 입력해주세요");
		return false;
	}
	if($('input[name=mempw2]').val()==""){
		alert("비밀번호 확인을 입력해주세요");
		$('input[name=mempw2]').focus();
		return false;
	}
	
	if($('input[name=memname]').val() == ""){
		alert("이름을 입력해주세요.");
		$('input[name=memname]').focus();
		return false;
	}

	if($('input[name=memrrn1]').val() == ""){
		alert("주민등록번호의 첫 번째 칸을 입력해주세요.");
		$('input[name=memrr1]').focus();
		return false;
	} 
	
	if($('input[name=memrrn2]').val() == ""){
		alert("주민등록번호의 두 번째 칸을 입력해주세요.");
		$('input[name=memrr2]').focus();
		return false;
	} 
	
	var chk = false;
    for(var i = 0; i < registerform.memkind.length; i++) {
    	if(registerform.memkind[i].checked == true) {
    		chk = true; // 하나라도 체크되면 true
    	}
	}
   if(chk == false) { // 하나도 체크되지 않았을 경우
     alert("회원 종류를 선택해주세요.")
     return false;
   }
	
	if(use == "missing"){
		alert('아이디를 입력해주세요.');
		$("input[name=memid]").focus();
		return false;
	}
	else if(use == "impossible"){
		alert('이미 등록된 아이디입니다');
		$('input[name=memid]').select();
		return false;
		
	}else if(isCheck == false){
		alert('중복체크 먼저 하세요');
		return false;
	}
	
	if(pwuse=="pwerror"){
		alert("비밀번호 형식이 잘못됐습니다.");
		return false;
	}

	if(pwsame == "nosame"){
		alert("비밀번호가 불일치합니다.");
		return false;
	}
	

}//writeSave()

function duplicate(){ // 중복체크 클릭
	isCheck = true;
    $.ajax({
		url : "IDCHECK_PROC.jsp",
		data : ({
			userid : $('input[name=memid]').val()
		}),
		success : function(data){
			
			if($('input[name=memid]').val()==""){
				$("#idmessage").html('<font color=red>아이디를 입력하세요.<font>').show();
				$('input[name=memid]').focus();
				use = "missing";
			}
			else if($('input[name=memid]').val().indexOf(" ") != -1){
				$("#idmessage").html('<font color=red>아이디에 공백은 포함할 수 없어요!🙄<font>').show();
				$('input[name=memid]').select();
				use = "impossible";
			}
			else if($.trim(data) == "NO"){
				$("#idmessage").html('<font color=red>이런! 먼저 이 아이디를 탐낸 누군가 있었나봐요.😢<font>').show();
				$('input[name=memid]').select();
				use = "impossible";
			}
			else if($.trim(data) == "YES"){
				$("#idmessage").html('<font color=blue>완벽해요! 아트#에서 유일무이한 멋진 아이디예요!<font>').show();
				use = "possible";
			}
		}
	});//ajax
}//duplicate


function keyd(){
	//alert(key);
	$('#idmessage').css('display','none');
	use = "";
	isCheck = false;
}


function pwcheck(){
	pw = $('input[name=mempw]').val();
	var regexp = /^[a-z0-9]{3,8}$/i;
	if(!regexp.test(pw)){
		alert('비밀번호 형식이 틀렸습니다.');
		pwuse = "pwerror";
		return;
	}
	
	var chk_num = pw.search(/[0-9]/);
	var chk_eng = pw.search(/[a-z]/i);
	if(chk_num < 0 || chk_eng < 0){
		alert('비밀번호는 영문자와 숫자의 조합으로 작성하세요');
		pwuse = "pwerror";
		return;
	}else{
		pwuse = "";
	}
	
}

function pw2check(){ // a1235 =>4번 호출
	//alert('pw2check');
	
	if($('input[name=mempw]').val() == $('input[name=mempw2]').val()){
		$('#pwmessage').html("<font color=blue>비밀번호를 바르게 입력하셨네요. 완벽해요!</font>");
		pwsame = "same";
	}
	else{
		$('#pwmessage').html("<font color=red>비밀번호가 일치하지 않아요. 다시 시도해보세요!</font>");
		pwsame = "nosame";
	}
}//pw2check()






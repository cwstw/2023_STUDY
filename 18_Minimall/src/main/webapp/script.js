/**
 * script.js
 */

var use;
var isCheck = false;
 
function writeSave(){ // 가입클릭
	//alert(1);
	if($('input[name=id]').val() == ""){
		alert("아이디를 입력해주세요.");
		$('input[name=id]').focus();
		return false;
	}
	if(use == "missing"){
		alert('아이디를 입력하세요');
		$("input[name=id]").focus();
		return false;
	}
	else if(use == "impossible"){
		alert('이미 등록된 아이디입니다');
		$('input[name=id]').select();
		return false;
		
	}else if(isCheck == false){
		alert('중복체크 먼저 하세요');
		return false;
	}
	
	
	if($('input[name=password]').val()==""){
		alert("비밀번호를 입력하세요");
		$('input[name=password]').focus();
		return false;
	}
	
	if(pwuse=="pwerror"){
		alert("비밀번호 형식이 잘못됐습니다.");
		return false;
	}
	
	if($('input[name=password]').val() == ""){
		alert("비밀번호를 입력해주세요.");
		$('input[name=password]').focus();
		return false;
	}
	if(pwsame == "nosame"){
		alert("비밀번호가 불일치합니다.");
		return false;
	}
	
	if($('input[name=name]').val() == ""){
		alert("이름을 입력해주세요.");
		$('input[name=name]').focus();
		return false;
	} 
}//writeSave()

function duplicate(){ // 중복체크 클릭
	isCheck = true;
    $.ajax({
		url : "id_check_proc.jsp",
		data : ({
			userid : $('input[name=id]').val()
		}),
		success : function(data){
			
			if($('input[name=id]').val()==""){
				$("#idmessage").html('<font color=red>아이디를 입력하세요<font>').show();
				$('input[name=id]').focus();
				use = "missing";
			}
			else if($.trim(data) == "NO"){
				$("#idmessage").html('<font color=red>이미 등록된 아이디입니다<font>').show();
				$('input[name=id]').select();
				use = "impossible";
			}
			else if($.trim(data) == "YES"){
				$("#idmessage").html('<font color=blue>사용가능한 아이디입니다<font>').show();
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
	//alert('pwcheck');
	//영문 대/소문자/숫자 조합 3~8자
	pw = $('input[name=password]').val();
	/*올바른형식
	a123
	
	잘못된형식
	a1
	aaa*/
	var regexp = /^[a-z0-9]{3,8}$/i;
	//if(pw.search(regexp)==-1){
	if(!regexp.test(pw)){
		alert('비밀번호 형식이 틀렸습니다.');
		pwuse = "pwerror";
		return ;
	}
	
	var chk_num = pw.search(/[0-9]/);
	var chk_eng = pw.search(/[a-z]/i);
	
	alert(chk_num +"," + chk_eng); 
	// pw : ab3=>2,0 aaa=>-1,0
	
	if(chk_num < 0 || chk_eng < 0){
		alert('비밀번호는 영문자와 숫자의 조합으로 작성하세요');
		pwuse = "pwerror";
	}else{
		pwuse = "";
	}
	
}

function pw2check(){ // a1235 =>4번 호출
	//alert('pw2check');
	
	if($('input[name=password]').val() == $('input[name=password2]').val()){
		$('#pwmessage').html("<font color=blue>비번 일치</font>");
		pwsame = "same";
	}
	else{
		$('#pwmessage').html("<font color=red>비번 불일치</font>");
		pwsame = "nosame";
	}
}//pw2check()










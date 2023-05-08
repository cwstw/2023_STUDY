package com.spring.com;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberBean {
	
	//@NotEmpty(message="아이디 입력 누락")
	private String id;
	//@NotEmpty(message="비밀번호 입력 누락")
	@Size(min = 3, max = 5, message = "3~5자리만 입력가능")
	@Pattern(regexp = "^[0-9]+$", message = "숫자만 입력하세요.")
	//regexp : regular expression 정규표현식
	private String passwd;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	
}

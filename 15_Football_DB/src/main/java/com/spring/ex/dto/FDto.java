package com.spring.ex.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class FDto {
	private int num;
	
	@NotBlank(message = "아이디를 입력하세요")
	private String id;

	@NotBlank(message = "비밀번호를 입력하세요")
	private String pw;

	@NotBlank(message = "국가를 선택하세요")
	private String win;

	@NotBlank(message = "국가를 하나 이상 선택하세요")
	private String round16;
	
	
	public FDto() {
		super();
	}
	public FDto(int num, String id, String pw, String win, String round16) {
		super();
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.win = win;
		this.round16 = round16;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getWin() {
		return win;
	}
	public void setWin(String win) {
		this.win = win;
	}
	public String getRound16() {
		return round16;
	}
	public void setRound16(String round16) {
		this.round16 = round16;
	}
	
}

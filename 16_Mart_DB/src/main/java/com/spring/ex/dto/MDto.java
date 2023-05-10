package com.spring.ex.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class MDto {
	
	private int num;
	
	@NotBlank(message = "id 입력누락")
	private String id;
	
	@NotBlank(message = "pw 입력누락")
	private String pw;
	
	@NotNull(message="1개 이상의 상품을 선택하세요")
	private String product;
	
	//@NotBlank(message = "time 입력 누락(@NotBlank)")
	//@NotEmpty(message = "time 입력 누락(@NotEmpty)")
	//@NotNull(message = "time 입력 누락(@NotNull)")
	@Length(min = 1, message = "time 입력 누락(@Length")
	private String time; // select~option
	
	@NotBlank(message="approve 입력 누락")
	private String approve;
	
	//@NotNull(message = "agree 입력 누락")
	private String agree;
	
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
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getApprove() {
		return approve;
	}
	public void setApprove(String approve) {
		this.approve = approve;
	}
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}
	
}
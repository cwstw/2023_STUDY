package com.spring.ex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class BookBean {
	
	//@NotEmpty(message = "제목 입력이 누락되었습니다.")
	//@NotNull(message = "제목 입력이 누락되었습니다.")
	@NotBlank(message = "제목 입력이 누락되었습니다.")
	private String title;
	
	@NotEmpty(message = "저자 입력이 누락되었습니다.")
	//@Size(min = 5, message = "5글자 이상 입력하세요.")
	@Length(min = 5, message = "5글자 이상 입력하세요.")
	private String author;
	
	@Length(max = 5, message = "5글자 이상 입력하세요.")
	@Pattern(regexp = "^[0-9]+$", message = "숫자만 입력하세요")
	private int price;
	
	
	@NotEmpty(message = "출판사 입력이 누락되었습니다.")
	private String publisher;
	
	@NotNull(message = "한 개 이상 선택하세요.")
	//@NotBlank(message = "한 개 이상 선택하세요.") 가능
	//@NotEmpty(message = "한 개 이상 선택하세요.") 가능
	//배열로 만들지 않아도 알아서 중간에 쉼표를 찍어서 문자열로 만들어 값을 반환
	private String bookstore;
	
	@NotNull(message = "한 개를 선택하세요.")
	//@NotBlank(message = "한 개를 선택하세요.") 가능
	//@NotEmpty(message = "한 개를 선택하세요.") 가능
	private String kind;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getBookstore() {
		return bookstore;
	}
	public void setBookstore(String bookstore) {
		this.bookstore = bookstore;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}

	
}

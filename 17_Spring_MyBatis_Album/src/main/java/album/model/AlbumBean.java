package album.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class AlbumBean {
	
	//mybatis를 위해서는 칼럼 이름과 변수 이름이 똑같아야 한다.
	
	private int num;
	
	@NotBlank(message = "제목 누락")
	private String title;
	
	@Size(min=3,max=7,message = "3~7글자 사이 입력")//갯수
	@NotBlank(message = "가수 누락")
	private String singer;
	
	@Min(value = 1000, message = "1000원 이상")//값
	@NotBlank(message = "가격 누락")
	private String price; //유효성 검사는 int면 불가
	@NotBlank(message = "발매일 누락")
	private String day;
	
	
	public AlbumBean() {
		super();
	}
	public AlbumBean(int num, String title, String singer, String price, String day) {
		super();
		this.num = num;
		this.title = title;
		this.singer = singer;
		this.price = price;
		this.day = day;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	
}

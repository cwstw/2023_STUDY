package travel.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

@Component("myTravelBean")
public class TravelBean {
	private final String must_input="필수 입력사항입니다.";
	private int num;
	
	@NotBlank(message = "아이디는 "+must_input)
	private String name;
	
	@Range(min = 10, max = 100, message = "10~100 사이의 수로 입력하세요.")
	@NotEmpty(message = "나이는 "+must_input)
	private String age;
	
	@NotNull(message = "1개 이상 선택하세요.")
	private String area;
	
	@NotBlank(message = "여행타입은 "+must_input)
	private String style;
	
	
	@NotBlank(message = "가격은 "+must_input)
	private String price;
	
	
	public TravelBean() {
		super();
	}
	public TravelBean(int num, String name, String age, String area, String style, String price) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.area = area;
		this.style = style;
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
}

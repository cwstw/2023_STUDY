package example2;

import org.springframework.stereotype.Component;

@Component("PointX") //객체 생성(원래는 안되지만 여기선 참조변수명이 클래스명과 같아도 됨)
public class PointX implements Shape{
	public PointX(){
		System.out.println("PointX()");
	}

	@Override
	public String make() {
		return "X를 만들다";
	}

	@Override
	public String delete() {
		return "X를 지우다";
	}
}

package example2;

import org.springframework.stereotype.Component;

@Component("PonitY")
public class PointY implements Shape{

	public PointY(){
		System.out.println("PointY()");
	}

	@Override
	public String make() {
		return "Y를 만들다";
	}

	@Override
	public String delete() {
		return "Y를 지우다";
	}
}

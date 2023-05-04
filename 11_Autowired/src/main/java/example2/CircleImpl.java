package example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myCircleImpl") //=CircleImpl myCircleImpl = new CircleImpl();
public class CircleImpl implements Circle{
	
	@Autowired //shape의 자식 객체를 넣어라(첫줄인 변수에만 적용)
	@Qualifier("PointX") //pointx 변수에 PointX 객체 정의
	Shape pointx;
	int x;
	int y;
	
	
	public Shape getPointx() {
		return pointx;
	}

	public void setPointx(Shape pointx) {
		System.out.println("setPointx()");
		this.pointx = pointx;
	}

	public CircleImpl() {
		System.out.println("CircleImpl()");
	}
	
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public String make() {
		return pointx.make();
	}

}

package example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myRetangleImpl")
public class RectangleImpl implements Rectangle{
	
	@Autowired
	@Qualifier("PointY")
	Shape pt;//부모인 shape 객체로 관리
	int x;
	int y;
	
	public Shape getPt() {
		return pt;
	}

	public void setPt(Shape pt) {
		this.pt = pt;
	}

	public RectangleImpl() {
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
		return pt.make();
	}

}

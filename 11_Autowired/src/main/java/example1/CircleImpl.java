package example1;

public class CircleImpl implements Circle{
	
	Shape pointx;//부모인 shape 객체로 관리
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

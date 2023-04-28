package sample3;

public class CircleImpl implements Circle{
	//원의 중심 좌표와 반지름
	//private double xpos;
	//private double ypos;
	private PointImpl point; //멤버변수 2개를 갖는 외부 클래스 변수
	private double radius;
	
	
	public CircleImpl(PointImpl point, double radius) {
		super();
		this.point = point;
		this.radius = radius;
	}
	
	public void display() {
		System.out.println("원의 중심 : "+point.getXpos()+","+point.getYpos());
		System.out.println("원의 면적 : "+getArea());
	}
	
	public double getArea() {
		return Math.pow(radius, 2)*Math.PI;
	}
}



package sample2;

public class Main {

	public static void main(String[] args) {
		//포인트 객체를 통해 값 주입
		PointImpl point = new PointImpl();
		point.setXpos(3.0);
		point.setYpos(4.0);
		
		CircleImpl circle = new CircleImpl(point, 10.0);
		circle.display();
	}

}

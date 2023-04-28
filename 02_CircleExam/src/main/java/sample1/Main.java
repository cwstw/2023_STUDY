package sample1;

public class Main {

	public static void main(String[] args) {
		//포인트 객체를 통해 값 주입
		Point point = new Point();
		point.setXpos(3.0);
		point.setYpos(4.0);
		
		Circle circle = new Circle(point, 10.0);
		circle.display();
	}

}

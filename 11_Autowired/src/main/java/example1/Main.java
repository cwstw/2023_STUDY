package example1;

public class Main {
	public static void main(String[] args) {
		Shape px = new PointX();
		PointY py = new PointY();
		CircleImpl circle =  new CircleImpl();//int 두개와 shape 타입 변수
		circle.setPointx(px);//무얼 넣느냐에 따라 출력이 달라짐
		System.out.println(circle.make());
		
		System.out.println("==================");
		
		RectangleImpl rect = new RectangleImpl();
		rect.setPt(py);
		System.out.println(rect.make());
	}
}

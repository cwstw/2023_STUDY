package example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//Shape px = new PointX(); 이미 완
		//PointX pt = new PointY(); 이미 완
		
		//xml 불러오기
		ApplicationContext context =
				new ClassPathXmlApplicationContext("appContext.xml");
		
		CircleImpl circle = (CircleImpl)context.getBean("myCircleImpl"); //CircleImpl 객체 참조변수
		System.out.println(circle.make());
		
		System.out.println("==================");
		
		RectangleImpl rect =
				(RectangleImpl)context.getBean("myRectangleImpl");
		System.out.println(rect.make());
		
	}
}

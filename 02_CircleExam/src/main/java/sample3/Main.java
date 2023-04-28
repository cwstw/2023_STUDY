package sample3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
		//포인트 객체를 통해 값 주입
//		PointImpl point = new PointImpl();
//		point.setXpos(3.0);
//		point.setYpos(4.0);
//		
//		CircleImpl circle = new CircleImpl(point, 10.0);
//		circle.display();
		
		//객체 생성한 파일 명시
		Resource resource = new ClassPathResource("appContext.xml");
		//빈 팩토리에서 빈 생성
		BeanFactory factory = new XmlBeanFactory(resource);
		
		Circle circle = (Circle)factory.getBean("circle");
		circle.display();
		
		Point point = (Point)factory.getBean("point");
		System.out.println("xpos : "+point.getXpos());
		System.out.println("ypos : "+point.getYpos());
	}

}

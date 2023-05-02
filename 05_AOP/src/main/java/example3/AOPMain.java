package example3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AOPMain {
	public static void main(String[] args) {
		//핵심기능 호출 시 알아서 다음 메서드 호출
		AbstractApplicationContext context =
				new GenericXmlApplicationContext("AOPExam.xml");
		
		Board myboard = (Board)context.getBean("myboard");
		Order myorder = (Order)context.getBean("myorder");
		
		myboard.board(); //실행 시 오류 : pom.xml 수정 필요
		myorder.order();
	}
}

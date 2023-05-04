package example4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//@ 이용
		ApplicationContext context =
				new ClassPathXmlApplicationContext("appContext2.xml");
		Person per = (Person)context.getBean("myConsumer");
		per.setName("정국");
		per.setAge(30);
		System.out.println(per.getName()+", "+per.getAge()+", "+per.personDrive());
	}

}

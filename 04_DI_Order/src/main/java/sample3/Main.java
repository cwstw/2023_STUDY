package sample3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
		Resource rs = new ClassPathResource("MyContext.xml");
		BeanFactory bf = new XmlBeanFactory(rs);
		MyInfo inf = (MyInfo)bf.getBean("myInfo");
	
		inf.personPrint();
		inf.studentPrint();
	}

}

package sample2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
//		Resource res = new ClassPathResource("OrderContext.xml");
//		BeanFactory bf = new XmlBeanFactory(res);
//		
//		ServiceImpl ser =  (ServiceImpl)bf.getBean("service");
		
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:OrderContext.xml");
		ServiceImpl ser = (ServiceImpl)context.getBean("service");
		ser.order();
		ser.cancel();
	}

}

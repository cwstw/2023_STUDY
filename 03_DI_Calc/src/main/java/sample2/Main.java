package sample2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
//		CalcBeanImpl cb = new CalcBeanImpl(4);
//		cb.setSu1(13);
		Resource resource = new ClassPathResource("appContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		CalcBeanImpl cb = (CalcBeanImpl)factory.getBean("cb");
		
		cb.calculate();
	}

}

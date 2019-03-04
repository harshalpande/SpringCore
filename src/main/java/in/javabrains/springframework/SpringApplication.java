package in.javabrains.springframework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import in.javabrains.springframework.bean.TriangleBean;

public class SpringApplication {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		TriangleBean triangleBean = context.getBean(TriangleBean.class);
		
		triangleBean.draw();
		
	}

}
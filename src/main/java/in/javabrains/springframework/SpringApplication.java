package in.javabrains.springframework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.javabrains.springframework.bean.CircleBean;
import in.javabrains.springframework.bean.Shape;
import in.javabrains.springframework.bean.TriangleBean;

public class SpringApplication {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		// TriangleBean triangleBean = context.getBean(TriangleBean.class); // Access way no 1

		// Shutdown hook must be registered to run destroy method from DisposableBean and Self Dispose Method from Spring.xml as well
		context.registerShutdownHook();
		
		//TriangleBean triangleBean = (TriangleBean) context.getBean("3PointAngle"); // Access way no 2 - using Alias
		
		Shape shape = (Shape) context.getBean(CircleBean.class);		// calling by Interface
		
		// for ApplicationContextAware - This is used to get ApplicationContext from Bean Class Object - A bad programming practice
		//ApplicationContext appContext = triangleBean.getApplicationContext();
		//System.out.println("Name: " + appContext.getApplicationName() + ", BeanName :" + triangleBean.getBeanName());
		
		shape.draw();		// Draw Method decides at runtime what to draw
		
		context.close();
		
	}

}
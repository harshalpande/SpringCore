package in.javabrains.springframework.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayNameBeanPostProcessor implements BeanPostProcessor {
	
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// Do some stuffs to bean Object - Common for all beans - After Initialization
		System.out.println("Post Processor After Initialization Bean Name "  + beanName);
		return bean;
	}
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// Do some stuffs to bean Object - Common for all beans - Before Initialization
		System.out.println("Post Processor Before Initialization Bean Name "  + beanName);
		return bean;
	}
}

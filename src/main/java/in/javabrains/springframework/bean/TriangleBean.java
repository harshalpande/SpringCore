package in.javabrains.springframework.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class TriangleBean implements Shape, ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean {

	/*
	 * private String type; private int height;
	 * 
	 * public TriangleBean(String type, int height) { this.height = height;
	 * this.type = type; }
	 * 
	 * public TriangleBean(String type) { this.type = type; }
	 * 
	 * public TriangleBean(int height) { this.height = height; }
	 * 
	 * public String getType() { return type; }
	 * 
	 * public void setType(String type, String height) { this.type = type; }
	 * 
	 * public int getHeight() { return height; }
	 * 
	 * public void setHeight(int height) { this.height = height; }
	 */

	private ApplicationContext appContext = null;

	private String beanName;

	private PointBean pointA;
	private PointBean pointB;
	private PointBean pointC;

	public PointBean getPointA() {
		return pointA;
	}

	public void setPointA(PointBean pointA) {
		this.pointA = pointA;
	}

	public PointBean getPointB() {
		return pointB;
	}

	public void setPointB(PointBean pointB) {
		this.pointB = pointB;
	}

	public PointBean getPointC() {
		return pointC;
	}

	public void setPointC(PointBean pointC) {
		this.pointC = pointC;
	}

	public void draw() {
		System.out.println("Printing Triangle");
		System.out.println("Point A" + getPointA().toString());
		System.out.println("Point B" + getPointB().toString());
		System.out.println("Point C" + getPointC().toString());
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.appContext = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return this.appContext;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getBeanName() {
		return this.beanName;
	}

	/**
	 * @see org.springframework.beans.factory.DisposableBean#destroy()
	 */
	public void destroy() throws Exception {
		System.out.println("Destroy Method Called after this current bean object is destroyed!!!");
	}
	
	public void myDestroyMethod() {
		System.out.println("My Destroy Method Called!!!");
	}

	/**
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	public void afterPropertiesSet() throws Exception {
		System.out.println("AfterPropertiesSet() Method Called before this current bean object is Initialized!!!");
	}
	
	public void myInitMethod() {
		System.out.println("My Init Method called!!!");
	}
}

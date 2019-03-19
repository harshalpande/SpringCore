package in.javabrains.springframework.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CircleBean implements Shape {
	
	public PointBean centre;

	public void draw() {
		System.out.println("Printing Circle");
		System.out.println("Circle is printed as :" + getCentre().toString());
	}

	public PointBean getCentre() {
		return centre;
	}

	//@Required - This is deprecated hence using Autowired
	/**
	 * if @Autowired is used then it checks for Spring.xml for all the type of beans avaiable with type PointBean. 
	 * if single bean is available of that type then it gets assigned automatically. 
	 * if it is not available then it checks that if the naming conventions are exactly same like "centre" over here
	 * else if nothing matches then it checks for the @Qualifier attribute property in spring.xml and assumes that 
	 * it is the one that will be autowired over here.
	 * 
	 * @param centre
	 */
	@Autowired
	@Qualifier("circleQualifier")		
	public void setCentre(PointBean centre) {
		this.centre = centre;
	}

}

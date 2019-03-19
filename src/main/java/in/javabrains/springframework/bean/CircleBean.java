package in.javabrains.springframework.bean;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import sun.util.locale.LanguageTag;

/**
 * @Component : from org.springframework.STEREOTYPE marks this class as BEAN, so
 *            you do not have to make an entry in spring.xml. But to do so,
 *            spring.xml needs to scan packages, hence just one annotation is
 *            required.
 * 
 *            We can annotate @Repository, @Service, @Controller from
 *            org.springframework.stereotype as well, to declare that this bean
 *            class performs specific operations and this annotations helps
 *            spring framework, identify and perform some other operations well.
 *            However in this case @component is just used to declare it as bean
 *            with Class Name in small case (here : circle).
 * 
 *            REPLACES: <bean id="circle" class=
 *            "in.javabrains.springframework.bean.CircleBean"></bean> from
 *            spring.xml
 * 
 * @author Harshal S Pande
 */
@Component
public class CircleBean implements Shape {

	public PointBean centre;

	/**
	 * Using Spring's dependency Injection to extract value of MessageSource from
	 * spring.xml
	 */
	@Autowired
	private MessageSource messageSource;

	public void draw() {
		System.out.println("Printing Circle");
		/*System.out
				.println("Circle is printed as :" + getCentre().getCoordinateX() + ", " + getCentre().getCoordinateY());*/
		System.out.println(messageSource.getMessage("circle.point",
				new Object[] { getCentre().getCoordinateX(), getCentre().getCoordinateY() }, "Circle properties",
				Locale.ENGLISH));
		System.out.println(messageSource.getMessage("blue", null, "BLUE COLOR", Locale.ENGLISH));
	}

	public PointBean getCentre() {
		return centre;
	}

	// @Required - This is deprecated hence using Autowired
	/**
	 * if @Autowired is used then it checks for Spring.xml for all the type of beans
	 * avaiable with type PointBean. if single bean is available of that type then
	 * it gets assigned automatically. if it is not available then it checks that if
	 * the naming conventions are exactly same like "centre" over here else if
	 * nothing matches then it checks for the @Qualifier attribute property in
	 * spring.xml and assumes that it is the one that will be autowired over here.
	 * 
	 * @param centre
	 */
	/*
	 * @Autowired
	 * 
	 * @Qualifier("circleQualifier") public void setCentre(PointBean centre) {
	 * this.centre = centre; }
	 */

	/**
	 * @Resource - JSR-250 Annotation from Javax.Annotation package Used just
	 *           like @autowired for direct injection. name attribute given is
	 *           directly injected if name is not given, it looks up spring.xml for
	 *           instance variable same name in spring.xml else gives exception.
	 * 
	 */
	@Resource(name = "point3")
	public void setCentre(PointBean centre) {
		this.centre = centre;
	}

	/**
	 * JSR - 250 Annotations from Javax.Annotation package 3rd Method : Used for
	 * calling init method of a Bean via annotations.
	 */
	@PostConstruct
	public void onAnnotationInit() {
		System.out.println("Annotation Init Method from JSR-250 Annotations.");
	}

	/**
	 * JSR - 250 Annotations from Javax.Annotation package 3rd Method : Used for
	 * calling destroy method of a Bean via annotations.
	 */
	@PreDestroy
	public void onAnnotationDestroy() {
		System.out.println("Annotation Destroy Method from JSR-250 Annotations.");
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

}

package in.javabrains.springframework.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Here we are using @Component, we can also register it as Bean in spring.xml
 * @author pandehar
 */
@Component
public class MyEventListener implements ApplicationListener<DrawEvent>{

	public void onApplicationEvent(DrawEvent event) {
		System.out.println("Source :" + event.getSource()
		+ " TimeStamp :" + event.getTimestamp()
		+ " \r Complete Data :" + event.toString()
				);
	}

}

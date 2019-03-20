package in.javabrains.springframework.event;

import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1858384016022174276L;

	public DrawEvent(Object source) {
		super(source);
	}

}

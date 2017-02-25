package com.careem.engine.web.event;

import org.springframework.context.ApplicationEvent;

public class EvaluateTestEvent extends ApplicationEvent {
	private static final long serialVersionUID = 1393271781363876000L;

	public EvaluateTestEvent(Object source) {
		super(source);
	}
}
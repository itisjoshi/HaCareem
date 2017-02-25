package com.careem.engine.web.event.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.careem.engine.web.event.EvaluateTestEvent;

@Component
public class EvaluateTestEventListener implements
		ApplicationListener<EvaluateTestEvent> {

	@Override
	public void onApplicationEvent(EvaluateTestEvent evaluateTestEvent) {
		// TODO Auto-generated method stub
	}
}
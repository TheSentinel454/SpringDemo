package com.dci.springdemo;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by ltornquist on 1/20/2015.
 */
@Component
public class MyEventListener implements ApplicationListener<DrawEvent> {
	@Override
	public void onApplicationEvent(DrawEvent drawEvent) {
		System.out.println("Application event: " + drawEvent.toString());
	}
}

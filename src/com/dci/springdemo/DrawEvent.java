package com.dci.springdemo;

import org.springframework.context.ApplicationEvent;

/**
 * Created by ltornquist on 1/20/2015.
 */
public class DrawEvent extends ApplicationEvent {
	public DrawEvent(Object source) {
		super(source);
	}

	@Override
	public String toString() {
		return "Draw Event occurred!";
	}
}

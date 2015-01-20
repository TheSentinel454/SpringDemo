package com.dci.springdemo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ltornquist on 1/16/2015.
 */
public class DrawingApp {

	public static void main(String[] args)
	{
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		Shape shape = (Shape) context.getBean("circle");
		shape.draw();
	}
}

package com.dci.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ltornquist on 1/16/2015.
 */
public class DrawingApp {

	public static void main(String[] args)
	{
		//Triangle triangle = new Triangle();
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));

		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		context.registerShutdownHook();
		Shape shape = (Shape) context.getBean("circle");
		shape.draw();
		Shape shape2 = (Shape) context.getBean("triangle");
		shape2.draw();
	}
}

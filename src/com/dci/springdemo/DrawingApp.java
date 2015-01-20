package com.dci.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ltornquist on 1/16/2015.
 */
public class DrawingApp {

	public static void main(String[] args)
	{
		//Triangle triangle = new Triangle();
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));

		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		Triangle triangle = (Triangle) context.getBean("triangle1");
		triangle.draw();
		Triangle triangle2 = (Triangle) context.getBean("triangle2");
		triangle2.draw();
	}
}

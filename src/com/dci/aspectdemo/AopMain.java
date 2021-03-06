package com.dci.aspectdemo;

import com.dci.aspectdemo.service.FactoryService;
import com.dci.aspectdemo.service.ShapeService;
import com.dci.springdemo.Shape;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ltornquist on 1/20/2015.
 */
public class AopMain {

	public static void main(String[] args)
	{
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		//ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
		FactoryService factoryService = new FactoryService();
		ShapeService shapeService = (ShapeService) factoryService.getBean("shapeService");

		shapeService.getCircle();
	}
}

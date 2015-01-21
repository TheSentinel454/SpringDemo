package com.dci.aspectdemo.service;

import com.dci.aspectdemo.model.Circle;
import com.dci.aspectdemo.model.Triangle;

/**
 * Created by ltornquist on 1/21/2015.
 */
public class FactoryService {

	public Object getBean(String beanType)
	{
		if (beanType.equals("shapeService"))
			return new ShapeServiceProxy();
		if (beanType.equals("circle"))
			return new Circle();
		if (beanType.equals("triangle"))
			return new Triangle();
		return null;
	}
}

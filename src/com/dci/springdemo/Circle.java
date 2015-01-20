package com.dci.springdemo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by ltornquist on 1/20/2015.
 */
@Controller
public class Circle implements Shape {

	private Point center;

	public Point getCenter() {
		return center;
	}
	@Resource(name="pointC")
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("Drawing Circle!");
		System.out.println("Center Point = (" + getCenter().getX() + "," + getCenter().getY() + ")");
	}

	@PostConstruct
	public void initializeCircle()
	{
		System.out.println("Initialize Circle!");
	}
	@PreDestroy
	public void destroyCircle()
	{
		System.out.println("Destroy Circle!");
	}
}

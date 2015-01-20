package com.dci.springdemo;

import org.springframework.beans.factory.annotation.Required;

/**
 * Created by ltornquist on 1/20/2015.
 */
public class Circle implements Shape {

	private Point center;

	public Point getCenter() {
		return center;
	}

	@Required
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("Drawing Circle!");
		System.out.println("Center Point = (" + getCenter().getX() + "," + getCenter().getY() + ")");
	}
}

package com.dci.springdemo;

import java.util.List;

/**
 * Created by ltornquist on 1/16/2015.
 */
public class Triangle {

	private List<Point> points;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void draw()
	{
		for(Point p: points)
			System.out.println("Point = (" + p.getX() + "," + p.getY() + ")");
	}
}

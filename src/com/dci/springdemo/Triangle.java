package com.dci.springdemo;

/**
 * Created by ltornquist on 1/16/2015.
 */
public class Triangle {

	private Point pointA;
	private Point pointB;
	private Point pointC;

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public void draw()
	{
		//for(Point p: points)
		//	System.out.println("Point = (" + p.getX() + "," + p.getY() + ")");
		System.out.println("Point A = (" + getPointA().getX() + "," + getPointA().getY() + ")");
		System.out.println("Point B = (" + getPointB().getX() + "," + getPointB().getY() + ")");
		System.out.println("Point C = (" + getPointC().getX() + "," + getPointC().getY() + ")");
	}
}

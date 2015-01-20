package com.dci.aspectdemo.service;

import com.dci.aspectdemo.model.Circle;
import com.dci.aspectdemo.model.Triangle;

/**
 * Created by ltornquist on 1/20/2015.
 */
public class ShapeService {
	private Circle circle;
	private Triangle triangle;

	public Triangle getTriangle() {
		return triangle;
	}

	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

	public Circle getCircle() {
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}
}

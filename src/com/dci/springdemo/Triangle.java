package com.dci.springdemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by ltornquist on 1/16/2015.
 */
public class Triangle implements ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean {

	private String name;
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private ApplicationContext context;

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

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("BeanName: " + name);
		this.name = name;
	}

	public void myInit()
	{
		System.out.println("MyInit!");
	}

	public void myDestroy()
	{
		System.out.println("MyDestroy!");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("AfterPropertiesSet!");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy!");
	}
}

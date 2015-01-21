package com.dci.aspectdemo.model;

/**
 * Created by ltornquist on 1/20/2015.
 */
public class Circle {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle's setName called!");
		//throw new RuntimeException();
	}

	public String setNameAndReturn(String name) {
		this.name = name;
		System.out.println("Circle's setNameAndReturn called!");
		return this.name;
	}
}

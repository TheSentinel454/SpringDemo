package com.dci.jdbcdemo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by ltornquist on 1/21/2015.
 */
@Entity
public class Circle {
	@Id
	private int id;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Circle(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
}

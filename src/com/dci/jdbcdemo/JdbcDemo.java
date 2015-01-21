package com.dci.jdbcdemo;

import com.dci.jdbcdemo.dao.JdbcDaoImpl;
import com.dci.jdbcdemo.model.Circle;

/**
 * Created by ltornquist on 1/21/2015.
 */
public class JdbcDemo {

	public static void main(String[] args)
	{
		Circle circle = new JdbcDaoImpl().getCircle(1);
		System.out.println(circle.getName());
	}
}

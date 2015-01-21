package com.dci.jdbcdemo;

import com.dci.jdbcdemo.dao.JdbcDaoImpl;
import com.dci.jdbcdemo.dao.SimpleJdbcDaoImpl;
import com.dci.jdbcdemo.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ltornquist on 1/21/2015.
 */
public class JdbcDemo {

	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		//JdbcDaoImpl dao = context.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		SimpleJdbcDaoImpl dao = context.getBean("simpleJdbcDaoImpl", SimpleJdbcDaoImpl.class);

		//dao.insertCircle(new Circle(5, "Fifth Circle"));
		System.out.println(dao.getCircleCount());
	}
}

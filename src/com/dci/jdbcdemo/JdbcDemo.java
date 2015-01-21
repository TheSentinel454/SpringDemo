package com.dci.jdbcdemo;

import com.dci.jdbcdemo.dao.HibernateDaoImpl;
import com.dci.jdbcdemo.dao.SimpleJdbcDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ltornquist on 1/21/2015.
 */
public class JdbcDemo {

	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		HibernateDaoImpl dao = context.getBean("hibernateDaoImpl", HibernateDaoImpl.class);

		System.out.println(dao.getCircleCount());
	}
}

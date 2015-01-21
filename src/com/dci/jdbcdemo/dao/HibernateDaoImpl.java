package com.dci.jdbcdemo.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by ltornquist on 1/21/2015.
 */
@Repository
public class HibernateDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public int getCircleCount()
	{
		String hql = "select count(*) from Circle";
		Query query = getSessionFactory().openSession().createQuery(hql);
		return ((Long)query.uniqueResult()).intValue();
	}
}

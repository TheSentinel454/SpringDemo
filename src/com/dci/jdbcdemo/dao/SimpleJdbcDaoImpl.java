package com.dci.jdbcdemo.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

/**
 * Created by ltornquist on 1/21/2015.
 */
public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport {
	public int getCircleCount()
	{
		return this.getJdbcTemplate().queryForObject("SELECT COUNT(*) FROM CIRCLE", Integer.class);
	}
}

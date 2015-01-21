package com.dci.jdbcdemo.dao;

import com.dci.jdbcdemo.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

/**
 * Created by ltornquist on 1/21/2015.
 */
@Component
public class JdbcDaoImpl {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public int getCircleCount()
	{
		String sql = "SELECT COUNT(*) FROM CIRCLE";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public String getCircleName(int circleId)
	{
		String sql = "SELECT name FROM circle WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, String.class, circleId);
	}

	public Circle getCircleForId(int circleId)
	{
		String sql = "SELECT * FROM circle WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new CircleMapper(), circleId);
	}

	public List<Circle> getAllCircles()
	{
		String sql = "SELECT * FROM circle";
		return jdbcTemplate.query(sql, new CircleMapper());
	}

	public void insertCircle(Circle circle)
	{
		String sql = "INSERT INTO CIRCLE (ID, NAME) VALUES (:id, :name)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", circle.getId())
													.addValue("name", circle.getName());
		namedParameterJdbcTemplate.update(sql, namedParameters);
	}

	public void createTriangleTable()
	{
		String sql = "CREATE TABLE triangle (ID INTEGER, NAME VARCHAR(50))";
		jdbcTemplate.execute(sql);
	}

	private static final class CircleMapper implements RowMapper<Circle> {
		@Override
		public Circle mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			return (new Circle(resultSet.getInt("id"), resultSet.getString("name")));
		}
	}
}

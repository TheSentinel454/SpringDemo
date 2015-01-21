package com.dci.jdbcdemo.dao;

import com.dci.jdbcdemo.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by ltornquist on 1/21/2015.
 */
@Component
public class JdbcDaoImpl {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		//this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	/*
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	*/

	public Circle getCircle(int circleId)
	{
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle WHERE id = ?");
			ps.setInt(1, circleId);

			Circle circle = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				circle = new Circle(circleId, rs.getString("name"));
			}
			rs.close();
			ps.close();
			return circle;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			if (conn != null)
			{
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
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
		//jdbcTemplate.queryForObject(sql, , circleId)
		return null;
	}
}

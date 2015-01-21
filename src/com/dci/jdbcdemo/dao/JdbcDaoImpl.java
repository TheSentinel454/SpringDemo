package com.dci.jdbcdemo.dao;

import com.dci.jdbcdemo.model.Circle;

import java.sql.*;

/**
 * Created by ltornquist on 1/21/2015.
 */
public class JdbcDaoImpl {

	public Circle getCircle(int circleId)
	{
		Connection conn = null;
		String driver = "org.apache.derby.jdbc.ClientDriver";

		try {
			Class.forName(driver).newInstance();

			conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
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
}

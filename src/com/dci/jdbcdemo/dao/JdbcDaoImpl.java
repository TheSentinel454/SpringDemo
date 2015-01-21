package com.dci.jdbcdemo.dao;

import com.dci.jdbcdemo.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by ltornquist on 1/21/2015.
 */
@Component
public class JdbcDaoImpl {
	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

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
}

package com.abinanth.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
	private ConnectionUtil() {

	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		 String driverClass = System.getenv("spring.datasource.driver-class-name");
		 String url = System.getenv("spring.datasource.url");
	 String username = System.getenv("spring.datasource.username");
		 String password = System.getenv("spring.datasource.password");
		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url, username, password);
		
		return connection;
	}

	public static void close(Statement st, Connection con) {
		try {
			if (con != null && st != null) {
				con.close();
				st.close();
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

package com.abinanth.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionUtil {
	private ConnectionUtil() {

	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String driverClass = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost/WasteManagement_db";
		String username = "postgres";
		String password = "Haicoimbatore1!";
		Class.forName(driverClass);
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connection Created");
		return connection;
	}

	public static void close(Statement st, Connection con) {
		try {
			if (con != null && st != null) {
				con.close();
				st.close();
				System.out.println("Connection Released");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

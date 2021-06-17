package com.abinanth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abinanth.model.UserLoginModel;
import com.abinanth.util.ConnectionUtil;

public class UsersDAO {
	
	public void addUser(UserLoginModel user) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO users(user_name,user_password) VALUES(?,?)";
			pst = connection.prepareStatement(sql);

			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}
	public List<UserLoginModel> displayUers() {
		Connection connection = null;
		PreparedStatement pst = null;
		List<UserLoginModel> userList = new ArrayList<>();
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM users";

			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				

				UserLoginModel user = new UserLoginModel(username, password);
				userList.add(user);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return userList;
	}

}

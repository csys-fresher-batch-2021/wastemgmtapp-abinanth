package com.abinanth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.abinanth.model.RecidencyModel;

import com.abinanth.util.ConnectionUtil;

public class RecidencyDAO {
	/*
	 * this method is used to insert a recidency details into recidencytype database
	 */

	public void save(RecidencyModel addRecidency) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "INSERT INTO recidency(recidencies) VALUES(?)";
			pst = connection.prepareStatement(sql);
			pst.setString(1, addRecidency.getNewRecidency());

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}
/*
 * this method is used to get all the date from recidencytype database
 */
	public List<RecidencyModel> findAll() {
		Connection connection = null;
		PreparedStatement pst = null;
		List<RecidencyModel> recidencyList = new ArrayList<>();
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM recidency";
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String recidencyName = rs.getString("recidencies");
				RecidencyModel recidency = new RecidencyModel(recidencyName);
				recidencyList.add(recidency);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return recidencyList;
	}
	/*
	 * this method is used to delete a recidency type from recidency type database
	 */

	public void deleteByRecidencyType(RecidencyModel deleteRecidency) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "DELETE FROM recidency WHERE recidencies=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, deleteRecidency.getNewRecidency());

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

}

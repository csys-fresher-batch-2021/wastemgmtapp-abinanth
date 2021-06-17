package com.abinanth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.abinanth.model.BillCalculatorModel;
import com.abinanth.util.ConnectionUtil;

public class RecidencyDetailsDAO {
	/*
	 * this method is used to add recidency details of respected user
	 */

	public void save(BillCalculatorModel recidencyFeilds) {
		Connection connection = null;
		PreparedStatement pst = null;

		try {

			connection = ConnectionUtil.getConnection();
			if (connection != null) {
				String sql = "INSERT INTO recidencytype(user_name,recidency_type,recidency_no,street_name,city_name,"
						+ "district_name,years)VALUES(?,?,?,?,?,?,?)";

				pst = connection.prepareStatement(sql);
				pst.setString(1, recidencyFeilds.getUserName());
				pst.setString(2, recidencyFeilds.getRecidenyType());
				pst.setInt(3, recidencyFeilds.getRecidencyNo());
				pst.setString(4, recidencyFeilds.getStreetName());
				pst.setString(5, recidencyFeilds.getCityName());
				pst.setString(6, recidencyFeilds.getDistrict());
				pst.setInt(7, recidencyFeilds.getYear());

				pst.executeUpdate();

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}
	/*
	 * this method is used to get all recidency details of respective user
	 */

	public List<BillCalculatorModel> findAll() {
		Connection connection = null;
		PreparedStatement pst = null;
		List<BillCalculatorModel> recidencyList = new ArrayList<>();
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM recidencytype";

			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String username = rs.getString("user_name");
				int recidencyId = rs.getInt("recidency_id");
				String recidencyType = rs.getString("recidency_type");
				int recidencyNo = rs.getInt("recidency_no");
				String streetName = rs.getString("street_name");
				String cityName = rs.getString("city_name");
				String district = rs.getString("district_name");
				int year = rs.getInt("years");

				BillCalculatorModel recidency = new BillCalculatorModel(username, recidencyType, recidencyNo,
						streetName, cityName, district, year, recidencyId);
				recidencyList.add(recidency);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return recidencyList;
	}
}

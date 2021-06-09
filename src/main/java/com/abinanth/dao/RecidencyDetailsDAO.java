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

	public void addNewRecidencyDetails(BillCalculatorModel recidencyFeilds) {
		Connection connection = null;
		PreparedStatement pst = null;

		try {

			connection = ConnectionUtil.getConnection();
			if (connection != null) {
				String sql = "INSERT INTO recidencytype(recidency_type,recidency_no,street_name,city_name,"
						+ "district_name,years)VALUES(?,?,?,?,?,?)";

				pst = connection.prepareStatement(sql);

				pst.setString(1, recidencyFeilds.getRecidenyType());
				pst.setString(2, recidencyFeilds.getRecidencyNo());
				pst.setString(3, recidencyFeilds.getStreetName());
				pst.setString(4, recidencyFeilds.getCityName());
				pst.setString(5, recidencyFeilds.getDistrict());
				pst.setString(6, recidencyFeilds.getYear());

				pst.executeUpdate();

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	public List<BillCalculatorModel> displayRecidencyDetails() {
		Connection connection = null;
		PreparedStatement pst = null;
		List<BillCalculatorModel> recidencyList = new ArrayList<>();
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM recidencytype";

			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String recidencyId = rs.getString("recidency_id");
				String recidencyType = rs.getString("recidency_type");
				String recidencyNo = rs.getString("recidency_no");
				String streetName = rs.getString("street_name");
				String cityName = rs.getString("city_name");
				String district = rs.getString("district_name");
				String year = rs.getString("years");

				BillCalculatorModel recidency = new BillCalculatorModel(recidencyId, recidencyType, recidencyNo,
						streetName, cityName, district, year);
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

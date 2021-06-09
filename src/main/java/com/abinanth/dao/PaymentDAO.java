package com.abinanth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abinanth.model.PaymentModel;

import com.abinanth.util.ConnectionUtil;

public class PaymentDAO {

	public void addPaymentDetails(PaymentModel pay) {
		Connection connection = null;
		PreparedStatement pst = null;

		try {

			connection = ConnectionUtil.getConnection();
			if (connection != null) {
				String sql = "INSERT INTO payment(recidency_no,recidency_type,amount,status) VALUES(?,?,?,'PENDING')";

				pst = connection.prepareStatement(sql);
				pst.setString(1, pay.getRecidencyNo());
				pst.setString(2, pay.getRecidencyType());
				pst.setString(3, pay.getAmount());

				pst.executeUpdate();

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	public void updatePayment(String recidencyNo) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE payment SET status='PAID' WHERE recidency_no=?";
			pst = connection.prepareStatement(sql);

			pst.setString(1, recidencyNo);

			pst.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	public List<PaymentModel> displayPaymentDetails() {
		Connection connection = null;
		PreparedStatement pst = null;
		List<PaymentModel> paymentStatus = new ArrayList<>();
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM payment";

			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String recidencyType = rs.getString("recidency_type");
				String amount = rs.getString("amount");
				String recidencyNo = rs.getString("recidency_no");
				String status = rs.getString("status");
				PaymentModel pay = new PaymentModel(recidencyType, amount, recidencyNo, status);
				paymentStatus.add(pay);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return paymentStatus;
	}

}

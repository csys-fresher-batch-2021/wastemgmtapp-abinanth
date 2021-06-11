package com.abinanth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.abinanth.model.PaymentModel;

import com.abinanth.util.ConnectionUtil;
import com.abinanth.util.Logger;

public class PaymentDAO {

	public void addPaymentDetails(PaymentModel pay) {
		Connection connection = null;
		PreparedStatement pst = null;
		Logger log = new Logger();
		log.print(pay.getUsername());
		try {

			connection = ConnectionUtil.getConnection();
			if (connection != null) {
				String sql = "INSERT INTO payment(recidency_no,recidency_type,amount,status,user_name) "
						+ "VALUES(?,?,?,'PENDING',?)";

				pst = connection.prepareStatement(sql);
				pst.setString(1, pay.getRecidencyNo());

				pst.setString(2, pay.getRecidencyType());
				pst.setString(3, pay.getAmount());
				pst.setString(4, pay.getUsername());

				pst.executeUpdate();

			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

	public void updatePayment(int paymentId) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE payment SET status='PAID' WHERE payment_id=?";
			pst = connection.prepareStatement(sql);

			pst.setInt(1, paymentId);

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
				String username = rs.getString("user_name");
				int paymentId = rs.getInt("payment_id");
				PaymentModel pay = new PaymentModel(recidencyNo, recidencyType, amount, status, username, paymentId);
				paymentStatus.add(pay);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return paymentStatus;
	}

	public List<PaymentModel> findRecidecyDetails(String word) {
		Connection connection = null;
		PreparedStatement pst = null;
		List<PaymentModel> find = new ArrayList<>();
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM payment where status ILIKE ? OR recidency_type ILIKE ?;";

			pst = connection.prepareStatement(sql);
			pst.setString(1, "%" + word + "%");
			pst.setString(2, "%" + word + "%");

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String recidencyType = rs.getString("recidency_type");
				String amount = rs.getString("amount");
				String recidencyNo = rs.getString("recidency_no");
				String status = rs.getString("status");
				String username = rs.getString("user_name");
				int paymentId = rs.getInt("payment_id");
				PaymentModel pay = new PaymentModel(recidencyNo, recidencyType, amount, status, username, paymentId);
				find.add(pay);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return find;

	}

	public List<PaymentModel> findMyBills(String username) {
		Connection connection = null;
		PreparedStatement pst = null;
		List<PaymentModel> bills = new ArrayList<>();
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "SELECT*FROM payment WHERE user_name=?";

			pst = connection.prepareStatement(sql);
			pst.setString(1, username);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String recidencyType = rs.getString("recidency_type");
				String amount = rs.getString("amount");
				String recidencyNo = rs.getString("recidency_no");
				String status = rs.getString("status");
				int paymentId = rs.getInt("payment_id");
				PaymentModel bill = new PaymentModel(recidencyNo, recidencyType, amount, status, username, paymentId);
				bills.add(bill);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return bills;

	}

}

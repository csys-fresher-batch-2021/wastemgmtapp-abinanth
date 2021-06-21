package com.abinanth.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.abinanth.exception.DBException;
import com.abinanth.model.PaymentModel;
import com.abinanth.services.PaymentService;
import com.abinanth.util.ConnectionUtil;
import com.abinanth.util.Logger;

public class PaymentDAO {
	private static final String RECIDENCY_NO = "recidency_no";
	private static final String RECIDENCY_TYPE = "recidency_type";
	private static final String AMOUNT = "amount";
	private static final String STATUS = "status";
	private static final String USER_NAME = "user_name";
	private static final String PAYMENT_ID = "payment_id";
	private static final String DUE_DATE = "due_date";
	private static final String FINE_AMOUNT = "fine_amount";
	private static final String PAID_DATE = "paid_date";
	private static final String TOTAL_AMOUNT = "total_amount";
	/*
	 * this meathod is used to add payment details
	 */
	static Logger log = new Logger();

	public void save(PaymentModel pay) {
		Connection connection = null;
		PreparedStatement pst = null;
		log.print(pay.getUsername());
		try {
			connection = ConnectionUtil.getConnection();
			if (connection != null) {
				String sql = "INSERT INTO payment(user_name,recidency_no,recidency_type,amount,status,"
						+ "due_date,total_amount,fine_amount) VALUES(?,?,?,?,?,?,?,?)";
				pst = connection.prepareStatement(sql);
				pst.setString(1, pay.getUsername());
				pst.setInt(2, pay.getRecidencyNo());
				pst.setString(3, pay.getRecidencyType());
				pst.setDouble(4, pay.getAmount());
				pst.setString(5, "PENDING");
				Date date = Date.valueOf(PaymentService.getDueDate());
				pst.setDate(6, date);
				pst.setDouble(7, pay.getAmount());
				pst.setDouble(8, pay.getFineAmount());
				pst.executeUpdate();
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Unable to insert details");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/*
	 * 
	 * This method is ised to update the status as paid with payment id
	 */
	public void updatePayment(int paymentId) {
		Connection connection = null;
		PreparedStatement pst = null;
		Date paymentDate = Date.valueOf(PaymentService.getPaidDate());
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE payment SET status='PAID', paid_date=? WHERE payment_id=?";
			pst = connection.prepareStatement(sql);
			pst.setDate(1, paymentDate);
			pst.setInt(2, paymentId);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Unable to update the status");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}
	/*
	 * this method is used to display all the reicidency details
	 */

	public List<PaymentModel> findAll() {
		Connection connection = null;
		PreparedStatement pst = null;
		List<PaymentModel> paymentStatus = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM payment";
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String recidencyType = rs.getString(RECIDENCY_TYPE);
				double amount = rs.getDouble(AMOUNT);
				int recidencyNo = rs.getInt(RECIDENCY_NO);
				String status = rs.getString(STATUS);
				String username = rs.getString(USER_NAME);
				int paymentId = rs.getInt(PAYMENT_ID);
				LocalDate dueDate = rs.getDate(DUE_DATE).toLocalDate();
				Double fineAmount = rs.getDouble(FINE_AMOUNT);
				Date paidDateTemp = rs.getDate(PAID_DATE);
				LocalDate paidDate = null;
				if (paidDateTemp != null) {
					paidDate = paidDateTemp.toLocalDate();
				}
				double totalAmount = rs.getDouble(TOTAL_AMOUNT);
				PaymentModel paymentDetails = new PaymentModel(username, recidencyNo, recidencyType, amount, status,
						paymentId, dueDate, fineAmount, paidDate, totalAmount);
				paymentStatus.add(paymentDetails);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Unable to show the details");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return paymentStatus;
	}
	/*
	 * this method is used to search the status and recidency details to admin
	 */

	public List<PaymentModel> findByRecidecyTypeOrStatus(String word) {
		Connection connection = null;
		PreparedStatement pst = null;
		List<PaymentModel> find = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM payment WHERE status ILIKE ? OR recidency_type ILIKE ?;";
			pst = connection.prepareStatement(sql);
			pst.setString(1, "%" + word + "%");
			pst.setString(2, "%" + word + "%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String recidencyType = rs.getString(RECIDENCY_TYPE);
				int amount = rs.getInt(AMOUNT);
				int recidencyNo = rs.getInt(RECIDENCY_NO);
				String status = rs.getString(STATUS);
				String username = rs.getString(USER_NAME);
				int paymentId = rs.getInt(PAYMENT_ID);
				LocalDate dueDate = rs.getDate(DUE_DATE).toLocalDate();
				Double fineAmount = rs.getDouble(FINE_AMOUNT);
				Date paidDateTemp = rs.getDate(PAID_DATE);
				LocalDate paidDate = null;
				if (paidDateTemp != null) {
					paidDate = paidDateTemp.toLocalDate();
				}
				double totalAmount = rs.getDouble(TOTAL_AMOUNT);
				PaymentModel pay = new PaymentModel(username, recidencyNo, recidencyType, amount, status, paymentId,
						dueDate, fineAmount, paidDate, totalAmount);
				find.add(pay);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return find;

	}
	/*
	 * this meathod is used to show the mill of the respected user
	 */

	public List<PaymentModel> findByUserName(String username) {
		Connection connection = null;
		PreparedStatement pst = null;
		List<PaymentModel> billList = new ArrayList<>();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT*FROM payment WHERE user_name=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String recidencyType = rs.getString(RECIDENCY_TYPE);
				int amount = rs.getInt(AMOUNT);
				username = rs.getString(USER_NAME);
				int recidencyNo = rs.getInt(RECIDENCY_NO);
				String status = rs.getString(STATUS);
				int paymentId = rs.getInt(PAYMENT_ID);
				LocalDate dueDate = rs.getDate(DUE_DATE).toLocalDate();
				Double fineAmount = rs.getDouble(FINE_AMOUNT);
				Date paidDateTemp = rs.getDate(PAID_DATE);
				LocalDate paidDate = null;
				if (paidDateTemp != null) {
					paidDate = paidDateTemp.toLocalDate();
				}
				double totalAmount = rs.getDouble(TOTAL_AMOUNT);
				log.print("my total bill" + totalAmount);
				PaymentModel bill = new PaymentModel(username, recidencyNo, recidencyType, amount, status, paymentId,
						dueDate, fineAmount, paidDate, totalAmount);
				billList.add(bill);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return billList;
	}
	/*
	 * this method is used to update the fine amount is the user is payed after due
	 * date
	 */

	public void updateFineAmount(double fineAmount, int paymentId) {
		Connection connection = null;
		PreparedStatement pst = null;
		log.print("DAO FineAmount " + fineAmount);
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE payment SET fine_amount=? WHERE payment_id=?";
			pst = connection.prepareStatement(sql);
			pst.setDouble(1, fineAmount);
			pst.setInt(2, paymentId);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("Unable to update");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}

	/*
	 * this method is used to get payment id
	 */
	public int findByRecidencyNo(int recidencyNo) {
		Connection connection = null;
		PreparedStatement pst = null;
		int paymentId = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT payment_id from payment where recidency_no=?";
			pst = connection.prepareStatement(sql);
			pst.setInt(1, recidencyNo);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				paymentId = rs.getInt(PAYMENT_ID);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException(e, "unable to update");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
		return paymentId;
	}

	/*
	 * this method is used to update total amount
	 */
	public void updateTotalAmount(double totalAmount, int paymentId) {
		Connection connection = null;
		PreparedStatement pst = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "UPDATE payment SET total_amount=?WHERE payment_id=?";
			pst = connection.prepareStatement(sql);
			pst.setDouble(1, totalAmount);
			pst.setInt(2, paymentId);
			pst.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			throw new DBException("unable to update");
		} finally {
			ConnectionUtil.close(pst, connection);
		}
	}
}

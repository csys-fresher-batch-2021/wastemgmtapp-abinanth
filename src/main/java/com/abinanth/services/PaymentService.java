package com.abinanth.services;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import com.abinanth.dao.PaymentDAO;
import com.abinanth.exception.DBException;
import com.abinanth.exception.ValidationException;
import com.abinanth.model.PaymentModel;
import com.abinanth.util.Logger;
import com.abinanth.validator.RecidencyStringValidator;

public class PaymentService {
	private PaymentService() {

	}

	static Logger log = new Logger();
	private static PaymentDAO dao = new PaymentDAO();
	/*
	 * this method is used to add payment details of resped user
	 */

	public static boolean addPaymentDetails(PaymentModel newPayment) {
		boolean flag = false;
	

		try {

			dao.save(newPayment);
			flag = true;

		} catch (ValidationException e) {

			e.printStackTrace();
			throw new ValidationException("Unable to add details");
		}

		return flag;
	}
/*
 * this method is used update the payment status
 */
	public static boolean updatePayment(int paymentId) {

		boolean flag = false;

		try {

			dao.updatePayment(paymentId);
			flag = true;
			log.print("Updated the status");

		} catch (DBException e) {
			throw new DBException("Cannot Update");

		}
		return flag;

	}
	/*
	 * this method is used to search the recidency details through recidency type or status
	 */

	public static List<PaymentModel> findRecidencyDetails(String word) {
		List<PaymentModel> search = new ArrayList<>();
		try {
			if (RecidencyStringValidator.stringValidation(word)) {
				search = dao.findByRecidecyTypeOrStatus(word);
				log.print(search);
			}

		} catch (DBException | ValidationException e) {
			throw new ValidationException(e.getMessage());
		}
		return search;

	}
/*
 * this method is used get all the payment details
 */
	public static List<PaymentModel> getAllPaymentDetails() {
		return dao.findAll();
	}
	/*
	 * this method is used to get bills of respective user
	 */

	public static List<PaymentModel> getUserBills(String username) {

		return dao.findByUserName(username);
	}
	/*
	 * this method is assign due date
	 */

	public static LocalDate getDueDate() {
		LocalDate today = LocalDate.now();

		LocalDate dueDate = today.plusDays(15);

		return dueDate;
	}
/*
 * this method is to set paid date
 */
	public static LocalDate getPaidDate() {
		LocalDate today = LocalDate.now();
		return today;
	}
	/*
	 * this method is to add fine amount by comparing paid date and due date 
	 */

	public static double addFineAmount(int paymentId) {
		LocalDate paidDate = LocalDate.now();

		double fineAmount = 0.0;
		List<PaymentModel> list = dao.findAll();
		for (PaymentModel checkFine : list) {
			LocalDate dueDate = checkFine.getDueDate();
			if (paidDate.isAfter(dueDate)) {
				fineAmount = 100.0;
			} else {
				fineAmount=0.0;
			}
		}
		if (fineAmount != 0.0) {
		dao.updateFineAmount(fineAmount, paymentId);

		
		}
		return fineAmount;
	

}

	/*
	 * this method is used to get payment id
	 */

	public static int getPaymentId(int recidencyNo) {
		int paymentId = 0;
		if (recidencyNo > 0) {
			paymentId = dao.findByRecidencyNo(recidencyNo);
		}
		return paymentId;

	}
	/*
	 * this method implents default fine amount
	 */

	public static double setDefaultFineAmount() {
		double defaultFinePay = 0.0;
		return defaultFinePay;
	}

}

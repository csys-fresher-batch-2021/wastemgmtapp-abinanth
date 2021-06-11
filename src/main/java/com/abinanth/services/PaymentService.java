package com.abinanth.services;

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

	public static boolean addPaymentDetails(PaymentModel newPayment) {
		boolean flag = false;

		try {

			dao.addPaymentDetails(newPayment);
			flag = true;

		} catch (ValidationException e) {

			e.printStackTrace();
			throw new ValidationException("Unable to add details");
		}

		return flag;
	}

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

	public static List<PaymentModel> findRecidencyDetails(String word) {
		List<PaymentModel> search = new ArrayList<>();
		try {
			if (RecidencyStringValidator.stringValidation(word)) {
				search = dao.findRecidecyDetails(word);
				log.print(search);
			}

		} catch (DBException | ValidationException e) {
			throw new ValidationException(e.getMessage());
		}
		return search;

	}

	public static List<PaymentModel> getAllPaymentDetails() {
		return dao.displayPaymentDetails();
	}

	public static List<PaymentModel> getUserBills(String userName) {

		return dao.findMyBills(userName);
	}
}

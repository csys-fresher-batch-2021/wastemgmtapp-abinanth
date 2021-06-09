package com.abinanth.services;

import com.abinanth.dao.PaymentDAO;
import com.abinanth.exception.ValidationException;
import com.abinanth.model.PaymentModel;
import com.abinanth.util.Logger;

public class PaymentService {
	private PaymentService() {

	}

	static Logger log = new Logger();

	public static boolean addPaymentDetails(PaymentModel newPayment) {
		boolean flag = false;

		try {

			PaymentDAO dao = new PaymentDAO();
			dao.addPaymentDetails(newPayment);
			flag = true;

		} catch (ValidationException e) {

			e.printStackTrace();
			throw new ValidationException("Unable to add details");
		}

		return flag;
	}

	public static boolean updatePayment(String recidencyNo) {
		log.print("Update");
		boolean flag = false;
		PaymentDAO dao = new PaymentDAO();
		for (PaymentModel status : dao.displayPaymentDetails()) {
			if (recidencyNo.equals(status.getRecidencyNo())) {
				dao.updatePayment(recidencyNo);
				flag = true;
				log.print("Updated the status");

			}

		}
		return flag;

	}
}

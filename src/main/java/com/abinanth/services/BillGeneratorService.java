package com.abinanth.services;

import java.util.List;

import com.abinanth.dao.PaymentDAO;
import com.abinanth.dao.RecidencyDetailsDAO;
import com.abinanth.model.BillCalculatorModel;
import com.abinanth.model.PaymentModel;
import com.abinanth.util.Logger;

public class BillGeneratorService {
	private BillGeneratorService() {

	}

	static PaymentDAO dao = new PaymentDAO();
static Logger log=new Logger();
/*
 * this method is used to get recidency id
 */
	public static int getId() {

		RecidencyDetailsDAO dao = new RecidencyDetailsDAO();
		int recidencyId = 0;
		for (BillCalculatorModel id : dao.findAll()) {
			recidencyId = id.getRecidencyId();

		}

		return recidencyId;
	}
/*
 * this method calculates the bill
 */
	public static double generateBill(String recidencyType, int userYear) {

		int year = userYear;
		double pay = 0;
		double amount = 0;

		if (recidencyType.equalsIgnoreCase("house")) {
			pay = 120;
		
		} else if (recidencyType.equalsIgnoreCase("shop")) {
			pay = 160;
		} else {
			pay = 200;
		}
		amount = getAmount(year, pay, amount);

		return amount;
	}
	/*
	 * this method check the year is between 1 to 4
	 */

	public static double getAmount(int year, double pay, double amount) {
		if (year < 4 || year > 0) {
			amount = pay * year;
		}
		return amount;
	}
	/*
	 * this method is for get total amount
	 */

	public static double getTotalAmount(int paymentId) {
		double totalAmount = 0.0;
		List<PaymentModel> list = dao.findAll();
log.print(PaymentService.addFineAmount(paymentId));
		for (PaymentModel amountList : list) {
			
			totalAmount = amountList.getAmount() + PaymentService.addFineAmount(paymentId);
			log.print(totalAmount);
			dao.updateTotalAmount(totalAmount, paymentId);
		}
		return totalAmount;
	}

}

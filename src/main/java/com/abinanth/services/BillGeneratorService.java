package com.abinanth.services;

import com.abinanth.dao.PaymentDAO;
import com.abinanth.dao.RecidencyDetailsDAO;
import com.abinanth.model.BillCalculatorModel;
import com.abinanth.util.Logger;

public class BillGeneratorService {
	private BillGeneratorService() {
		//default constructor
	}

	static PaymentDAO dao = new PaymentDAO();
	static Logger log = new Logger();

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
		if (recidencyType.equals("house")) {
			pay = 120;
		} else if (recidencyType.equals("shop")) {
			pay = 160;
		} else {
			pay = 200;
		}
		amount = isValidAmount(year, pay, amount);
		return amount;
	}
	/*
	 * this method check the year is between 1 to 4
	 */

	public static double isValidAmount(int year, double pay, double amount) {
		if (year < 4 || year > 0) {
			amount = pay * year;
		}
		return amount;
	}
}

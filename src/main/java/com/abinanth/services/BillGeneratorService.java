package com.abinanth.services;

import com.abinanth.dao.RecidencyDetailsDAO;
import com.abinanth.model.BillCalculatorModel;

public class BillGeneratorService {
	private BillGeneratorService() {

	}

	public static String getId() {

		RecidencyDetailsDAO dao = new RecidencyDetailsDAO();
		String recidencyId = null;
		for (BillCalculatorModel id : dao.displayRecidencyDetails()) {
			recidencyId = id.getRecidencyId();
			break;
		}

		return recidencyId;
	}

	public static String generateBill(String recidencyType, String userYear) {

		int year = Integer.parseInt(userYear);
		int pay = 0;
		int amount = 0;

		if (recidencyType.equalsIgnoreCase("house")) {
			pay = 120;

		} else if (recidencyType.equalsIgnoreCase("shop")) {
			pay = 160;
		} else {
			pay = 200;
		}
		amount = getAmount(year, pay, amount);

		return String.valueOf(amount);
	}

	public static int getAmount(int year, int pay, int amount) {
		if (year < 4 || year > 0) {
			amount = pay * year;
		}
		return amount;
	}

}

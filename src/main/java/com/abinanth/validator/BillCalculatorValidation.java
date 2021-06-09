package com.abinanth.validator;

public class BillCalculatorValidation {
	private BillCalculatorValidation() {

	}

	public static boolean recidencyTypeValidation(String username) {

		boolean isValidService = true;

		if (username.length() == 0 || username.trim().equals("")) {
			isValidService = false;
		}

		return isValidService;
	}

}

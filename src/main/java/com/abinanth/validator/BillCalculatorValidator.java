package com.abinanth.validator;

public class BillCalculatorValidator {
	private BillCalculatorValidator() {

	}

	public static boolean recidencyTypeValidation(String username) {
		boolean isValidService = true;
		if (username.length() == 0 || username.trim().equals("")) {
			isValidService = false;
		}
		return isValidService;
	}

}

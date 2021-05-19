package com.abinanth.validator;

public class RecidencyStringValidator {
	private RecidencyStringValidator() {

	}

	/**
	 * // String validation is performed // insertion of numbers is recidency type
	 * is checked
	 * 
	 * @param newRecidencyName
	 * @return
	 */
	public static boolean stringValidation(String recidencyName) {

		boolean isValidService = true;

		if (recidencyName.length() == 0 || recidencyName.trim().equals("")) {
			isValidService = false;
		}

		for (int index = 0; index < recidencyName.length(); index++) {
			if (recidencyName.charAt(index) >= '0' && recidencyName.charAt(index) <= '9') {
				isValidService = false;

			}
		}
		return isValidService;
	}

}

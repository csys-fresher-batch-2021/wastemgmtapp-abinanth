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
	public static boolean stringValidation(String newRecidencyName) {

		boolean isValidService = true;

		if (newRecidencyName.length() == 0 || newRecidencyName.trim().equals("")) {
			isValidService = false;
		}

		for (int index = 0; index < newRecidencyName.length(); index++) {
			if (newRecidencyName.charAt(index) >= '0' && newRecidencyName.charAt(index) <= '9') {
				isValidService = false;

			}
		}
		return isValidService;
	}

}

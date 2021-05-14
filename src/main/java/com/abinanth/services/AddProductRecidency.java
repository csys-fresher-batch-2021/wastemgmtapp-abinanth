package com.abinanth.services;

import java.util.ArrayList;
import java.util.List;

import com.abinanth.validator.RecidencyStringValidator;

public class AddProductRecidency {
	private static final List<String> recidencyType = new ArrayList<>();

	private AddProductRecidency() {

	}

	public static List<String> displayRecidencyType() {
		return recidencyType;

	}

	/**
	 * // adding recidency in lowercase // checking wheather the recidecy value
	 * contain in arraylist // if new value string is validated
	 * 
	 * @param newRecidency
	 * @return
	 */
	public static boolean addRecidencyType(String newRecidency) {
		boolean valid = false;
		if (RecidencyStringValidator.stringValidation(newRecidency)) {
			newRecidency = newRecidency.toLowerCase();
			if (recidencyType.contains(newRecidency)) {
				valid = false;
			} else {
				recidencyType.add(newRecidency);
				valid = true;
			}
		}

		return valid;

	}

}

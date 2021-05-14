package com.abinanth.services;

import java.util.ArrayList;
import java.util.List;

import com.abinanth.validator.recidencyStringValidator;

public class AddProductRecidency {
	private static final List<String> recidencyType = new ArrayList<>();

	private AddProductRecidency() {

	}

	public static List<String> displayRecidencyType() {
		return recidencyType;

	}
/**
 * // adding recidency in lowercase
 * // checking wheather the recidecy value contain in arraylist
 * // if new value string is validated
 * @param newRecidency
 * @return
 */
	public static boolean addRecidencyType(String newRecidency) {
		boolean valid = false;

		newRecidency = newRecidency.toLowerCase(); 
	
		
		if (recidencyType.contains(newRecidency)) {
			System.out.println("Already Exist");
			valid = false;
		} else {
			
			if (recidencyStringValidator.stringValidation(newRecidency)) {
				recidencyType.add(newRecidency);
				valid = true;
			}
		}

		return valid;

	}

}

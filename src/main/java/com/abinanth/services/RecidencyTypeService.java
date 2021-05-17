package com.abinanth.services;

import java.util.ArrayList;

import java.util.List;

public class RecidencyTypeService {

	private RecidencyTypeService() {

	}

	private static final List<String> recidencyType = new ArrayList<>();
	static {
		recidencyType.add("House");
		recidencyType.add("Shop");
		recidencyType.add("Industry");
	}

	public static List<String> displayRecidencyType() {
		return recidencyType;

	}

	public static boolean addRecidencyType(String newRecidency) {

		boolean valid = false;

		if (recidencyType.contains(newRecidency)) {
			
			valid = false;
		} else {
			recidencyType.add(newRecidency);
			valid = true;
		}

		return valid;

	}

}

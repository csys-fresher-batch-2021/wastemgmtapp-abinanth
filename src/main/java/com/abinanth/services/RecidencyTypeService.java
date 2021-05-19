package com.abinanth.services;

import java.util.ArrayList;

import java.util.List;


public class RecidencyTypeService {

	private RecidencyTypeService() {

	}

	private static final List<String> recidencyType = new ArrayList<>();
	static {
		recidencyType.add("house");
		recidencyType.add("shop");
		recidencyType.add("industry");
	}

	public static List<String> displayRecidencyType() {
		return recidencyType;
		

	}

	public static boolean addRecidencyType(String newRecidency) {
		newRecidency=newRecidency.toLowerCase();

		boolean valid = false;

		if (recidencyType.contains(newRecidency)) {
			
			valid = false;
		} else {
			
			recidencyType.add(newRecidency);
			valid = true;
		}

		return valid;

	}
	public static boolean deleteRecidencyType(String deleteRecidency) {
		boolean valid = false;
	
			if (recidencyType.contains(deleteRecidency)) {
				recidencyType.remove(deleteRecidency);
				valid = true;
			}


		return valid;

	}

}

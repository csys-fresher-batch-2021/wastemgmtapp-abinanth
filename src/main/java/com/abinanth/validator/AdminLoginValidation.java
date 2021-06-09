package com.abinanth.validator;

public class AdminLoginValidation {
	private AdminLoginValidation() {

	}

	public static boolean adminValidation(String adminName, String password) {
		boolean valid = false;
		if ("admin".equals(adminName) && "admin".equals(password)) {
			valid = true;
		}
		return valid;
	}

}

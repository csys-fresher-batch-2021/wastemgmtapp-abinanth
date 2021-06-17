package com.abinanth.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidator {
	private LoginValidator() {

	}

	public static boolean checkUserName(String username) {
		boolean isValid = false;
		String regexPattern = "^[a-zA-Z]{3,12}";
		if (LoginValidator.validatedUserName(username)) {

			Pattern pattern = Pattern.compile(regexPattern);
			Matcher match = pattern.matcher(username);
			isValid = match.matches();

		}
		return isValid;
	}

	public static boolean checkPassword(String password) {
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z]).{8,20}$";

		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(password);
		return m.matches();
	}

	public static boolean validatedUserName(String username) {
		boolean isCorrectUsername = true;

		if (username.length() == 0 || username.trim().equals("")) {
			isCorrectUsername = false;
		}

		for (int index = 0; index < username.length(); index++) {
			if (username.charAt(index) >= '0' && username.charAt(index) <= '9') {
				isCorrectUsername = false;

			}
		}
		return isCorrectUsername;
	}

}

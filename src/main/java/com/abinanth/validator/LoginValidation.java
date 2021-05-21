package com.abinanth.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidation {
	private LoginValidation() {
		
	}
	public static boolean checkUserName(String username) {
		boolean isValid=false;
		String regexPattern="^[a-zA-Z]{3,12}";
		if(RecidencyStringValidator.stringValidation(username)) {
			Pattern pattern=Pattern.compile(regexPattern);
			Matcher match=pattern.matcher(username);
			isValid=match.matches();

		}
		return isValid;
	}

}

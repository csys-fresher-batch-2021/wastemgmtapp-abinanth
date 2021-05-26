package com.abinanth.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.abinanth.model.UserLoginModel;

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
	public static boolean checkPassword(String password) {
		String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
		Pattern pattern=Pattern.compile(regex);
	    Matcher m = pattern.matcher(password);
		return m.matches();
	}

}

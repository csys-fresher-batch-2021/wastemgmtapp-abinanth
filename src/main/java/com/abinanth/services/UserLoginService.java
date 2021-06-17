package com.abinanth.services;

import com.abinanth.exception.ValidationException;

import com.abinanth.validator.LoginValidator;

public class UserLoginService {
	private UserLoginService() {

	}

	public static boolean addUserLogin(String username, String password) {
		boolean userValidation = false;
		if (LoginValidator.checkUserName(username) && LoginValidator.checkPassword(password)) {
			userValidation = true;

		} else {
			throw new ValidationException("Invalid");
		}

		return userValidation;
	}

}

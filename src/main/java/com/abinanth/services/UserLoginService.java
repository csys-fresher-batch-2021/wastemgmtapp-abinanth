package com.abinanth.services;

import com.abinanth.exception.ValidationException;

import com.abinanth.validator.LoginValidation;

public class UserLoginService {
	private UserLoginService() {

	}

	public static boolean addUserLogin(String username, String password) {
		boolean userValidation = false;
		if (LoginValidation.checkUserName(username) && LoginValidation.checkPassword(password)) {
			userValidation = true;

		} else {
			throw new ValidationException("Invalid");
		}

		return userValidation;
	}

}

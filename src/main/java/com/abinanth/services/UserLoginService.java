package com.abinanth.services;


import com.abinanth.validator.LoginValidation;
import com.abinanth.validator.RecidencyStringValidator;


public class UserLoginService {
	private UserLoginService() {
		
	}	
		public static boolean checkUserLogin(String username,String password) {
			boolean userValidation = false;
			if (LoginValidation.checkUserName(username)&& LoginValidation.checkPassword(password)&&RecidencyStringValidator.stringValidation(username)){
				userValidation=true;
			}
			return userValidation;

		}
	
	
	
		}


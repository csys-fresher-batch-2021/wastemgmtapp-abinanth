package com.abinanth.services;


import com.abinanth.validator.LoginValidation;

import com.abinanth.model.*;

public class UserLoginService {
	public UserLoginService(String username, String password) {
		
	}	
		public static boolean checkUserLogin(String username,String password) {
			boolean userValidation = false;
			if (LoginValidation.checkUserName(username)&& LoginValidation.checkPassword(password)){
				userValidation=true;
			}
			return userValidation;

		}
	
	
	
		}


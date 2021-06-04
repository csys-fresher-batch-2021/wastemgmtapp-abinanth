package com.abinanth.services;



import com.abinanth.validator.LoginValidation;



public class UserLoginService {
	private UserLoginService() {
		
	}	
	
		public static boolean addUserLogin(String username,String password) {
			boolean userValidation = false;
			
			if (LoginValidation.checkUserName(username)&& LoginValidation.checkPassword(password)){
			
				userValidation=true;
			}
			return userValidation;

		}
	
	
	
		
//public static boolean  validUserLogin(String username,String password) {
//	
//	boolean flag=dao.validUserLogin(username, password);
//	return flag;
//}

}


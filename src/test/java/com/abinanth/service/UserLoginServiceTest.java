package com.abinanth.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.abinanth.services.UserLoginService;
import com.abinanth.validator.LoginValidation;

public class UserLoginServiceTest {

	@Test
	public void correctUserName() {
		String username="abinanth";
	
		boolean usernameTest = LoginValidation.checkUserName(username);
		assertTrue(usernameTest);
	}
	@Test
	public void wrongCorrectPassword() {
		String password="  ";
		boolean addUserLogin = LoginValidation.checkPassword(password);
		assertFalse(addUserLogin);
	}
	@Test
	public void inCorrectUserName() {
		String username="abinanth11";
	
		boolean usernameTest = LoginValidation.checkUserName(username);
		assertFalse(usernameTest);
	}
	@Test
	public void correctPassword() {
		String password="Haicoimbatore1";
	
		boolean checkpassword = LoginValidation.checkPassword(password);
		assertTrue(checkpassword);
	}


}

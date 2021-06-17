package com.abinanth.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.abinanth.validator.LoginValidator;

public class UserLoginServiceTest {

	@Test
	public void correctUserName() {
		String username = "abinanth";

		boolean usernameTest = LoginValidator.checkUserName(username);
		assertTrue(usernameTest);
	}

	@Test
	public void wrongCorrectPassword() {
		String password = "  ";
		boolean addUserLogin = LoginValidator.checkPassword(password);
		assertFalse(addUserLogin);
	}

	@Test
	public void inCorrectUserName() {
		String username = "abinanth11";

		boolean usernameTest = LoginValidator.checkUserName(username);
		assertFalse(usernameTest);
	}

	@Test
	public void correctPassword() {
		String password = "Haicoimbatore1";

		boolean checkpassword = LoginValidator.checkPassword(password);
		assertTrue(checkpassword);
	}

}

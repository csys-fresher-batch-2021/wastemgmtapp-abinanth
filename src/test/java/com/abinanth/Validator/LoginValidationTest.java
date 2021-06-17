package com.abinanth.Validator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.abinanth.validator.LoginValidator;

public class LoginValidationTest {

	@Test
	public void correctUserName() {
		String username = "abi";
		boolean expected = LoginValidator.checkUserName(username);
		assertTrue(expected);
	}

	@Test
	public void invalidUserName() {
		String username = "ab";
		boolean expected = LoginValidator.checkUserName(username);
		assertFalse(expected);
	}

	@Test
	public void invalidUserNameWithNumbers() {
		String username = "abi123";
		boolean expected = LoginValidator.checkUserName(username);
		assertFalse(expected);
	}

	@Test
	public void userNameInSpace() {
		String username = "";
		boolean expected = LoginValidator.checkUserName(username);
		assertFalse(expected);
	}

}

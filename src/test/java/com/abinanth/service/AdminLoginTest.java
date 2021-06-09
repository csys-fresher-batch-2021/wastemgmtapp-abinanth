package com.abinanth.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.abinanth.services.AdminLogin;

public class AdminLoginTest {

	@Test
	public void correctAdminDetails() {
		String username = "admin";
		String userPassword = "admin123";
		boolean isValid = AdminLogin.checkAdminLogin(username, userPassword);
		assertTrue(isValid);
	}

	@Test
	public void inCorrectAdminDetails() {
		String username = "admi";
		String userPassword = "adm";
		boolean isValid = AdminLogin.checkAdminLogin(username, userPassword);
		assertFalse(isValid);
	}

	@Test
	public void inCorrectAdminDetailsWithNumbers() {
		String username = "admi123";
		String userPassword = "adm12";
		boolean isValid = AdminLogin.checkAdminLogin(username, userPassword);
		assertFalse(isValid);
	}

}

package com.abinanth.services;

import java.util.HashMap;

public class AdminLogin {
	private AdminLogin() {

	}

	private static final HashMap<String, String> adminLoginDetails = new HashMap<>();
	static {
		adminLoginDetails.put("admin", "admin123");
	}

	public static boolean checkAdminLogin(String userAdmin, String userPassword) {
		boolean adminValidation = false;
		if (adminLoginDetails.containsKey(userAdmin)) {
			String adminPassword = adminLoginDetails.get(userAdmin);
			if (adminPassword.equals(userPassword)) {
				adminValidation = true;
			}
		}
		return adminValidation;

	}
}

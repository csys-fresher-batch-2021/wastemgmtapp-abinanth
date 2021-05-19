package com.abinanth.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.abinanth.services.RecidencyTypeService;

public class RecidencyTypeServiceTest {

	@Test
	public void addProduct() {
		String newRecidency = "textile";

		boolean newProductAdded = RecidencyTypeService.addRecidencyType(newRecidency);

		// System.out.println(recidencyType);
		assertTrue(newProductAdded);

	}

	@Test
	public void addingExistingRecidency() {
		String newRecidency = "industry";

		boolean existingProductAdded = RecidencyTypeService.addRecidencyType(newRecidency);
		assertFalse(existingProductAdded);

	}

}

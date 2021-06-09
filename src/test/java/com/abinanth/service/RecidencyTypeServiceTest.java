package com.abinanth.service;

import static org.junit.Assert.*;
import org.junit.Test;

import com.abinanth.exception.InputMissMatchException;
import com.abinanth.model.RecidencyModel;
import com.abinanth.services.RecidencyTypeService;

public class RecidencyTypeServiceTest {

	@Test
	public void addProduct() {
		RecidencyModel addRecidency = new RecidencyModel("Dying industry");

		boolean newProductAdded = RecidencyTypeService.addRecidencyType(addRecidency);
		assertTrue(newProductAdded);

	}

	@Test
	public void addingExistingRecidency() {

		RecidencyModel addRecidency = new RecidencyModel("textile");
		try {
			boolean existingProductAdded = RecidencyTypeService.addRecidencyType(addRecidency);
		} catch (InputMissMatchException e) {
			assertEquals("unable to add", e.getMessage());

		}

	}
}

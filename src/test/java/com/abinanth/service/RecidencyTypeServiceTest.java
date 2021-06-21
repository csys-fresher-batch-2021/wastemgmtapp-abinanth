package com.abinanth.service;

import static org.junit.Assert.*;
import org.junit.Test;

import com.abinanth.exception.InputMissMatchException;
import com.abinanth.model.RecidencyModel;
import com.abinanth.services.RecidencyTypeService;

public class RecidencyTypeServiceTest {

	public void addProduct() {
		RecidencyModel addRecidency = new RecidencyModel("");

		boolean newProductAdded = RecidencyTypeService.addRecidencyType(addRecidency);
		assertFalse(newProductAdded);

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

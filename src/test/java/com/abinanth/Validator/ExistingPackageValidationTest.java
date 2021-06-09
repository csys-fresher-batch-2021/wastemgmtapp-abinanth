package com.abinanth.Validator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.abinanth.model.BillCalculatorModel;
import com.abinanth.validator.ExistingRecidencyValidation;

public class ExistingPackageValidationTest {

	@Test

	public void recidencyValidationWithExistingDetails() {
		String recidencyType = "house";
		BillCalculatorModel check = new BillCalculatorModel("7140", recidencyType, "13/3a", "deepam nagar", "irugur",
				"cbe", "2");
		boolean existingProduct = ExistingRecidencyValidation.isExistingRecidencyValue(check);
		assertTrue(existingProduct);
	}
}

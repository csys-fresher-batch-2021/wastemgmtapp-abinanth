package com.abinanth.Validator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.abinanth.model.BillCalculatorModel;
import com.abinanth.validator.ExistingRecidencyValidator;

public class ExistingPackageValidationTest {

	@Test

	public void recidencyValidationWithExistingDetails() {
		String recidencyType = "house";
		BillCalculatorModel check = new BillCalculatorModel("abi", recidencyType, 13, "deepam nagar", "irugur", "cbe",
				2, 7140);
		boolean existingProduct = ExistingRecidencyValidator.isExistingRecidencyDetail(check);
		assertTrue(existingProduct);
	}
}

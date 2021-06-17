package com.abinanth.Validator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.abinanth.model.BillCalculatorModel;
import com.abinanth.validator.RecidencyDetailsValidator;

public class RecidencyDetailsValidationTest {

	@Test
	public void test() {

		BillCalculatorModel test = new BillCalculatorModel("abi", "shop", 13, "deepam", "irugur", "cbe", 2, 7168);
		boolean correctdetail = RecidencyDetailsValidator.isValidRecidency(test);
		assertEquals(true, correctdetail);
	}

	public void incorrectDetails() {

		BillCalculatorModel test = new BillCalculatorModel("abi", "  ", 13, "  ", "irugur", "cbe", 2, 7168);
		boolean correctdetail = RecidencyDetailsValidator.isValidRecidency(test);
		assertEquals(false, correctdetail);
	}

}

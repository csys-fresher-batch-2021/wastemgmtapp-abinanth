package com.abinanth.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.abinanth.model.BillCalculatorModel;
import com.abinanth.services.BillCalculatorService;

public class BillCalculatorTest {
	@Test
	public void correctRecidencyTypeAndCity() {

		BillCalculatorModel recidencyDetails = new BillCalculatorModel("abi", "house", 8003, "deepam nagar", "irugur",
				"cbe", 1, 2);
		boolean isValid = BillCalculatorService.addRecidencyDetails(recidencyDetails);
		assertEquals(true, isValid);
	}

	public void inCorrectRecidencyTypeAndCity() {

		BillCalculatorModel recidencyDetails = new BillCalculatorModel(" ", "house", 1, "deepam", "irugur", "cbe", 1,
				3);
		boolean isValid = BillCalculatorService.addRecidencyDetails(recidencyDetails);
		assertEquals(false, isValid);
	}

}

package com.abinanth.service;

import static org.junit.Assert.*;



import com.abinanth.model.BillCalculatorModel;
import com.abinanth.services.BillCalculatorService;

public class BillCalculatorTest {

	
	public void correctRecidencyTypeAndCity() {

		BillCalculatorModel recidencyDetails = new BillCalculatorModel("abi", "house", 99, "deepam nagar", "irugur", "cbe", 1, 2);
		boolean isValid = BillCalculatorService.addRecidencyDetails(recidencyDetails);
		assertEquals(true, isValid);
	}
	public void inCorrectRecidencyTypeAndCity() {

		BillCalculatorModel recidencyDetails = new BillCalculatorModel("abi", "house",1, "deepam", "irugur", "cbe", 1, 3);
		boolean isValid = BillCalculatorService.addRecidencyDetails(recidencyDetails);
		assertEquals(false, isValid);
	}

}

package com.abinanth.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.abinanth.model.BillCalculatorModel;
import com.abinanth.services.BillCalculatorService;

public class BillCalculatorTest {

	
	public void correctRecidencyTypeAndCity() {

		BillCalculatorModel recidencyDetails = new BillCalculatorModel("abi",7140,13, "deepam nagar",
				"irugur", "cbe", 2);
		boolean isValid = BillCalculatorService.addRecidencyDetails(recidencyDetails);
		assertEquals(true, isValid);
	}
	public void inCorrectRecidencyTypeAndCity() {

		BillCalculatorModel recidencyDetails = new BillCalculatorModel("abi",7141, 13, "deepam nagar", "Irugur",
				"CBE", 2);
		boolean isValid = BillCalculatorService.addRecidencyDetails(recidencyDetails);
		assertEquals(false, isValid);
	}

}

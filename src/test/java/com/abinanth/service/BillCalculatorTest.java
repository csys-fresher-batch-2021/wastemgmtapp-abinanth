package com.abinanth.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.abinanth.model.BillCalculatorModel;
import com.abinanth.services.BillCalculatorService;

public class BillCalculatorTest {

	@Test
	public void correctRecidencyTypeAndCity() {
		
		BillCalculatorModel recidencyDetails=new BillCalculatorModel("7140","textile","13/31", "deepam nagar", "irugur", "cbe", "2");
		boolean isValid=BillCalculatorService.addRecidencyDetails(recidencyDetails);
		assertEquals(true, isValid);
	}
@Test
	public void inCorrectRecidencyTypeAndCity() {
		
		BillCalculatorModel recidencyDetails=new BillCalculatorModel("7141","", "13/3a", "deepam nagar", "Irugur", "CBE", "2");
		boolean isValid=BillCalculatorService.addRecidencyDetails(recidencyDetails);
		assertEquals(false, isValid);
	}

}

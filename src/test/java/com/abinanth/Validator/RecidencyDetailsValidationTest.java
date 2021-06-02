package com.abinanth.Validator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.abinanth.model.BillCalculatorModel;
import com.abinanth.validator.RecidencyDetailsValidation;

public class RecidencyDetailsValidationTest {

	@Test
	public void test() {
	
		BillCalculatorModel test=new BillCalculatorModel("7168","shop", "13", "deepam", "irugur", "cbe", "2");
		boolean correctdetail = RecidencyDetailsValidation.isCorrectdetail(test);
		assertEquals(true,correctdetail);
	}

	@Test
	public void incorrectDetails() {
	
		BillCalculatorModel test=new BillCalculatorModel("7168","  ", "13", "  ", "irugur", "cbe", "2");
		boolean correctdetail = RecidencyDetailsValidation.isCorrectdetail(test);
		assertEquals(false,correctdetail);
	}

}

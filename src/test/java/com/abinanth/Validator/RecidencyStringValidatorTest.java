package com.abinanth.Validator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.abinanth.validator.RecidencyStringValidator;

public class RecidencyStringValidatorTest {

	@Test
	public void validTest() {
		String newstring = "wood";
		boolean isValid = RecidencyStringValidator.stringValidation(newstring);
		assertTrue(isValid);
	}

	@Test
	public void invaliTestSpaceValue() {
		String newstring = " ";
		boolean isValid = RecidencyStringValidator.stringValidation(newstring);
		assertFalse(isValid);
	}

	@Test
	public void invaliTestNullValue() {
		String newstring = "";
		boolean isValid = RecidencyStringValidator.stringValidation(newstring);
		assertFalse(isValid);
	}

	@Test
	public void invaliTestWithNumbers() {
		String newstring = "indus765";
		boolean isValid = RecidencyStringValidator.stringValidation(newstring);
		assertFalse(isValid);
	}
}

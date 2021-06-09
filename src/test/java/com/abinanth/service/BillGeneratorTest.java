package com.abinanth.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.abinanth.services.BillGeneratorService;

public class BillGeneratorTest {

	@Test
	public void test() {

		String generateBill = BillGeneratorService.generateBill("house", "1");
		assertEquals("120", generateBill);
	}

}

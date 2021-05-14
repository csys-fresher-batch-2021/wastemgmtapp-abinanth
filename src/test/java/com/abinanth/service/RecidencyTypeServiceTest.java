package com.abinanth.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.abinanth.services.RecidencyTypeService;

public class RecidencyTypeServiceTest {

	@Test
	public void test() {
		List<String> recidencyType = RecidencyTypeService.displayRecidencyType();

		assertEquals(3, recidencyType.size());

	}

	private static final List<String> recidencyType = new ArrayList<>();

	@Test
	public void addRecidency() {
		String newRecidency = "Textile";

		boolean exist = RecidencyTypeService.addRecidencyType(newRecidency);
		assertTrue(exist);

	}

}

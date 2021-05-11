package com.abinanth.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.abinanth.services.RecidencyTypeService;

public class RecidencyTypeServiceTest {

	@Test
	public void test() {
		List<String> recidencyType = RecidencyTypeService.getRecidencyType();
		System.out.println(recidencyType);
		assertEquals(3, recidencyType.size());

	}

}

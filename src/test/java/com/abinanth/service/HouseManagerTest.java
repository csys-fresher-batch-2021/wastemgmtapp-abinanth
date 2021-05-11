package com.abinanth.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.abinanth.services.HouseManagerService;

public class HouseManagerTest {

//	@Test
//	public void test() {
//		String house = "13" + "," + "anna" + "," + "CBE";	
//		HouseManager.addHouse("13", "anna", "CBE");
//		
//		assertTrue(HouseManager.exists(house));
//	}
	@Test
	public void dispalyHouseDetails1() {
		int actualSize = HouseManagerService.displayAllHouseDetails().size();
		assertNotEquals(2, actualSize);
	}
	
	
	@Test
	public void dispalyHouseDetails2() {
		int actualSize = HouseManagerService.displayAllHouseDetails().size();
		assertNotEquals(2, actualSize);
	}
	}
	



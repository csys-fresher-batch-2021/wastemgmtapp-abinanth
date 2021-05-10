package com.abinanth.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.abinanth.services.HouseManager;

public class HouseManagerTest {

	@Test
		public void dispalyHouseDetails() {
			int actualSize = HouseManager.displayAllHouseDetails().size();
			assertEquals(1, actualSize);
		}
	@Test
	public void dispalyHouseDetails1() {
		int actualSize = HouseManager.displayAllHouseDetails().size();
		assertNotEquals(2, actualSize);
	}
	}
	



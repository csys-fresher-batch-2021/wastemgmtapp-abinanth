package com.abinanth.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.abinanth.services.AddProductRecidency;
public class AddProductRecidencyTest {

	
	
		@Test
		public void addProduct(){
			String newRecidency="Textile";
			
	boolean newProductAdded=AddProductRecidency.addRecidencyType(newRecidency);

	//System.out.println(recidencyType);
			assertTrue(newProductAdded);
			
	}
		@Test
		public void addProductExisting(){
			String newRecidency="Industry";
			
	boolean existingProductAdded=AddProductRecidency.addRecidencyType(newRecidency);
			assertTrue(existingProductAdded);
			
	}
		@Test
		public void addProductExistingNull(){
			String newRecidency=" ";
			
	boolean existingProductAdded=AddProductRecidency.addRecidencyType(newRecidency);
			assertFalse(existingProductAdded);
			
	}
		@Test
		public void addProductExistingWithNumbers(){
			String newRecidency="ind22ustry5644 ";
			
	boolean existingProductAdded=AddProductRecidency.addRecidencyType(newRecidency);
			assertFalse(existingProductAdded);
			
	}
		@Test
		public void addProductExistingWithCapital(){
			String newRecidency="INDUSRTY";
			
	boolean existingProductAdded=AddProductRecidency.addRecidencyType(newRecidency);
			assertTrue(existingProductAdded);
			
	}
	}




package com.abinanth.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.abinanth.services.AddProductRecidency;
import com.abinanth.services.RecidencyTypeService;


public class AddProductRecidencyTest {
	private static final List<String> recidencyType = new ArrayList<>();
	
	
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




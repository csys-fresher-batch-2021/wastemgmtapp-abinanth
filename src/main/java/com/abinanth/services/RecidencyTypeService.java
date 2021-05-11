package com.abinanth.services;

import java.util.ArrayList;
import java.util.List;

public class RecidencyTypeService
{
	
	private static final List<String> recidencyType=new ArrayList<>();
	static {
		recidencyType.add("House");
		recidencyType.add("Shop");
		recidencyType.add("Industry");
	}
	public static List<String> getRecidencyType() {
		return recidencyType;
	
	}
//	public static List<String> displayAllRecidencyType() {
//		return recidencyType;
//	}

}

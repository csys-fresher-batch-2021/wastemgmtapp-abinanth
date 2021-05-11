package com.abinanth.services;

import java.util.ArrayList;

public class HouseManagerService {

	private static  final ArrayList<String> houseList = new ArrayList<String>();

//	public static String addHouse(String houseNo, String street, String city) {
//		String house = houseNo + "," + street + "," + city;
//		
//		System.out.println(houseList);
//		return house;
//
//	}
//	
//	public static boolean exists(String house){
//		return houseList.contains(house);
//	}
	
	
	// adding houseNo, street, city
	static {
		
		String houseNo="13/3a";
		String street="anna";
		String city="CBE";
		String house = houseNo + "," + street + "," + city;
		houseList.add(house);
	}
	public static ArrayList<String> displayAllHouseDetails(){
		return houseList;
	}
	public static void displayAllHouse() {
		for (String house : houseList) {
			System.out.println(house);
		}
	}
}


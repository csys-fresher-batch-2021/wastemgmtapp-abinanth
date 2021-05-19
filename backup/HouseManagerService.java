package com.abinanth.services;

import java.util.ArrayList;
import java.util.List;

public class HouseManagerService {
	private HouseManagerService() {

	}

	private static final ArrayList<String> houseList = new ArrayList<>();

	static {

		String houseNo = "13/3a";
		String street = "anna";
		String city = "CBE";
		String house = houseNo + "," + street + "," + city;
		houseList.add(house);
	}

	public static List<String> displayAllHouseDetails() {
		return houseList;
	}

}

package com.abinanth.model;

public class BillCalculatorModel {

	private String userName;
	private int recidencyId;
	private String recidenyType;
	private int recidencyNo;
	private String streetName;
	private String cityName;
	private String district;
	private int year;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRecidenyType() {
		return recidenyType;
	}

	public void setRecidenyType(String recidenyType) {
		this.recidenyType = recidenyType;
	}

	public int getRecidencyNo() {
		return recidencyNo;
	}

	public void setRecidencyNo(int recidencyNo) {
		this.recidencyNo = recidencyNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRecidencyId() {
		return recidencyId;
	}

	public void setRecidencyId(int recidencyId) {
		this.recidencyId = recidencyId;
	}

	public BillCalculatorModel(String userName, String recidenyType, int recidencyNo, String streetName,
			String cityName, String district, int year, int recidencyId) {
		super();
		this.userName = userName;
		this.recidenyType = recidenyType;
		this.recidencyNo = recidencyNo;
		this.streetName = streetName;
		this.cityName = cityName;
		this.district = district;
		this.year = year;
		this.recidencyId = recidencyId;
	}

	public BillCalculatorModel() {
		// default constructor
	}

	@Override
	public String toString() {
		return "BillCalculatorModel [userName=" + userName + ", recidencyId=" + recidencyId + ", recidenyType="
				+ recidenyType + ", recidencyNo=" + recidencyNo + ", streetName=" + streetName + ", cityName="
				+ cityName + ", district=" + district + ", year=" + year + "]";
	}

}

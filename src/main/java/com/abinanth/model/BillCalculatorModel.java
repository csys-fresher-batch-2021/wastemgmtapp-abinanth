package com.abinanth.model;

public class BillCalculatorModel {

	public BillCalculatorModel() {
		super();

	}

	private String recidenyType;
	private String recidencyNo;
	private String streetName;
	private String cityName;
	private String district;
	private String year;
	private String recidencyId;

	public String getRecidenyType() {
		return recidenyType;
	}

	public void setRecidenyType(String recidenyType) {
		this.recidenyType = recidenyType;
	}

	public String getRecidencyNo() {
		return recidencyNo;
	}

	public void setRecidencyNo(String recidencyNo) {
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRecidencyId() {
		return recidencyId;
	}

	public void setRecidencyId(String recidencyId) {
		this.recidencyId = recidencyId;
	}

	@Override
	public String toString() {
		return "SelectRecidencyTypeModel [recidenyType=" + recidenyType + ", recidencyNo=" + recidencyNo
				+ ", streetName=" + streetName + ", cityName=" + cityName + ", district=" + district + ", year=" + year
				+ ", recidencyId=" + recidencyId + "]";
	}

	public BillCalculatorModel(String recidenyType, String recidencyNo, String streetName, String cityName,
			String district, String year, String recidencyId) {
		super();
		this.recidenyType = recidenyType;
		this.recidencyNo = recidencyNo;
		this.streetName = streetName;
		this.cityName = cityName;
		this.district = district;
		this.year = year;
		this.recidencyId = recidencyId;
	}
}

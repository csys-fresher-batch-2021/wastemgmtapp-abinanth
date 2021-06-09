package com.abinanth.validator;

import com.abinanth.model.BillCalculatorModel;

public class RecidencyDetailsValidation {
	private RecidencyDetailsValidation() {

	}

	public static boolean isCorrectdetail(BillCalculatorModel addRecidencyDetails) {
		boolean isValid = true;

		if (!BillCalculatorValidation.recidencyTypeValidation(addRecidencyDetails.getRecidenyType())) {

			isValid = false;
		}
		if (!BillCalculatorValidation.recidencyTypeValidation(addRecidencyDetails.getRecidencyNo())) {

			isValid = false;
		}
		if (!BillCalculatorValidation.recidencyTypeValidation(addRecidencyDetails.getStreetName())) {

			isValid = false;
		}
		if (!BillCalculatorValidation.recidencyTypeValidation(addRecidencyDetails.getCityName())) {

			isValid = false;
		}
		if (!BillCalculatorValidation.recidencyTypeValidation(addRecidencyDetails.getDistrict())) {

			isValid = false;
		}
		if (!BillCalculatorValidation.recidencyTypeValidation(addRecidencyDetails.getYear())) {

			isValid = false;
		}

		return isValid;
	}

}

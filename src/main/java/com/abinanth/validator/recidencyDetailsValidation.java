package com.abinanth.validator;
import com.abinanth.exception.InputMissMatchException;
import com.abinanth.model.BillCalculatorModel;

public class recidencyDetailsValidation {
	private recidencyDetailsValidation() {
		
	}
	public static boolean isCorrectdetail(BillCalculatorModel addRecidencyDetails) {
		boolean isValid=true;
	try {
			if(!BillCalculatorValidation.recidencyTypeValidation(addRecidencyDetails.getRecidenyType())) {

				isValid = false;
			}
			if(!BillCalculatorValidation.recidencyTypeValidation(addRecidencyDetails.getRecidencyNo())) {

				isValid = false;
			}
			if(!BillCalculatorValidation.recidencyTypeValidation(addRecidencyDetails.getStreetName())) {

				isValid = false;
			}
			if(!BillCalculatorValidation.recidencyTypeValidation(addRecidencyDetails.getCityName())) {

				isValid = false;
			}
			if(!BillCalculatorValidation.recidencyTypeValidation(addRecidencyDetails.getDistrict())) {

				isValid = false;
			}
			if(!BillCalculatorValidation.recidencyTypeValidation(addRecidencyDetails.getYear())) {

				isValid = false;
			}
		
		
	} catch (InputMissMatchException e) {
		e.printStackTrace();
		throw new InputMissMatchException("Enter all details correctly");

	}
		
		return isValid;
	}

}

package com.abinanth.services;

import java.util.List;

import com.abinanth.dao.RecidencyDetailsDao;
import com.abinanth.exception.InputMissMatchException;

import com.abinanth.model.BillCalculatorModel;
import com.abinanth.validator.ExistingRecidencyValidation;
import com.abinanth.validator.recidencyDetailsValidation;

public class BillCalculatorService {
	private BillCalculatorService() {

	}

	static RecidencyDetailsDao dao = new RecidencyDetailsDao();

	public static List<BillCalculatorModel> getAllRecidencyType() {

		return dao.displayRecidencyDetails();

	}
	

	public static boolean addRecidencyDetails(BillCalculatorModel recidencyFeilds) {
		boolean isValid = false;

		try {
			boolean existingRecidencyValue = ExistingRecidencyValidation.isExistingRecidencyValue(recidencyFeilds);
			boolean correctdetail = recidencyDetailsValidation.isCorrectdetail(recidencyFeilds);
			
			if (existingRecidencyValue) {

				if (correctdetail) {

					dao.addNewRecidencyDetails(recidencyFeilds);
					isValid = true;

				}
			}
		} catch (InputMissMatchException e) {
			e.printStackTrace();
			throw new InputMissMatchException("Unable to add recidency Detail");
		}

		return isValid;

	}
}

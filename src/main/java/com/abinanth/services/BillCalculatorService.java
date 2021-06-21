package com.abinanth.services;

import java.util.List;

import com.abinanth.dao.RecidencyDetailsDAO;
import com.abinanth.exception.ValidationException;
import com.abinanth.model.BillCalculatorModel;
import com.abinanth.util.Logger;
import com.abinanth.validator.ExistingRecidencyValidator;
import com.abinanth.validator.RecidencyDetailsValidator;

public class BillCalculatorService {
	private BillCalculatorService() {
		//default constructor
	}
	static Logger log = new Logger();
	static RecidencyDetailsDAO dao = new RecidencyDetailsDAO();
	/*
	 * this method is used to get the recidency type
	 */
	public static List<BillCalculatorModel> getAllRecidencyType() {
		return dao.findAll();
	}

	/*
	 * this method is used to add recidency type
	 */
	public static boolean addRecidencyDetails(BillCalculatorModel recidencyFeilds) {
		boolean isValid = false;
		try {
			boolean existingRecidencyValue = ExistingRecidencyValidator.isExistingRecidencyDetail(recidencyFeilds);
			boolean correctdetail = RecidencyDetailsValidator.isValidRecidency(recidencyFeilds);
			if (!existingRecidencyValue) {
				throw new ValidationException("Already exists");
			}
			if (!correctdetail) {
				throw new ValidationException("Invalid Details");
			}
			dao.save(recidencyFeilds);
			isValid = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}
}

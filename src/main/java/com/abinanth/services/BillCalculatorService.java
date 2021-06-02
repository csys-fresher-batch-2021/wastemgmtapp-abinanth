package com.abinanth.services;

import java.util.List;

import com.abinanth.dao.RecidencyDetailsDao;
import com.abinanth.exception.ValidationException;
import com.abinanth.model.BillCalculatorModel;
import com.abinanth.util.Logger;
import com.abinanth.validator.ExistingRecidencyValidation;
import com.abinanth.validator.RecidencyDetailsValidation;

public class BillCalculatorService {
	private BillCalculatorService() {

	}

	static RecidencyDetailsDao dao = new RecidencyDetailsDao();

	public static List<BillCalculatorModel> getAllRecidencyType() {

		return dao.displayRecidencyDetails();

	}
static Logger log=new Logger();
	public static boolean addRecidencyDetails(BillCalculatorModel recidencyFeilds) {
		boolean isValid = false;

		try {
			boolean existingRecidencyValue = ExistingRecidencyValidation.isExistingRecidencyValue(recidencyFeilds);
			boolean correctdetail = RecidencyDetailsValidation.isCorrectdetail(recidencyFeilds);
			log.print(existingRecidencyValue);
			if (!existingRecidencyValue) {
				
				throw new ValidationException("Already exists");
				
			}
			log.print(existingRecidencyValue);
			
			if( !correctdetail) {
				throw new ValidationException("Invalid Details");
			}
			log.print(correctdetail);
				dao.addNewRecidencyDetails(recidencyFeilds);
				isValid = true;

			
		} catch (Exception e) {
			e.printStackTrace();
		
		}

		return isValid;

	}
}

package com.abinanth.validator;

import java.util.List;

import com.abinanth.dao.RecidencyDetailsDAO;
import com.abinanth.model.BillCalculatorModel;

public class ExistingRecidencyValidator {
	private ExistingRecidencyValidator() {

	}

	public static boolean isExistingRecidencyDetail(BillCalculatorModel addRecidencyDetails) {

		boolean isSame = true;
		RecidencyDetailsDAO dao = new RecidencyDetailsDAO();
		List<BillCalculatorModel> recidencydetailsList = dao.findAll();
		for (BillCalculatorModel checkRecidencyDetails : recidencydetailsList) {
			if (checkRecidencyDetails.getRecidencyNo()==addRecidencyDetails.getRecidencyNo()
					&& checkRecidencyDetails.getCityName().equalsIgnoreCase(addRecidencyDetails.getCityName())
					&& checkRecidencyDetails.getDistrict().equalsIgnoreCase(addRecidencyDetails.getDistrict())
					&& checkRecidencyDetails.getStreetName().equalsIgnoreCase(addRecidencyDetails.getStreetName())
					&& checkRecidencyDetails.getYear()==addRecidencyDetails.getYear()
					&& checkRecidencyDetails.getRecidenyType()
							.equalsIgnoreCase(addRecidencyDetails.getRecidenyType())) {
				isSame = false;
			}
		}
		return isSame;
	}

}

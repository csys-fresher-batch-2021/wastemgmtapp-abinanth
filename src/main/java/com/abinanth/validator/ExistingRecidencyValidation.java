package com.abinanth.validator;

import java.util.List;

import com.abinanth.dao.RecidencyDetailsDao;
import com.abinanth.model.BillCalculatorModel;

public class ExistingRecidencyValidation {
	private ExistingRecidencyValidation() {
		
	}
	public static boolean isExistingRecidencyValue(BillCalculatorModel addRecidencyDetails) {
		
		boolean isSame=true;
			RecidencyDetailsDao dao=new RecidencyDetailsDao();
			List<BillCalculatorModel> recidencydetailsList=dao.displayRecidencyDetails();
			for(BillCalculatorModel checkRecidencyDetails:recidencydetailsList) {
			if(checkRecidencyDetails.getRecidencyNo().equalsIgnoreCase(addRecidencyDetails.getRecidencyNo())
					&& checkRecidencyDetails.getCityName().equalsIgnoreCase(addRecidencyDetails.getCityName())
					&& checkRecidencyDetails.getDistrict().equalsIgnoreCase(addRecidencyDetails.getDistrict())
					&& checkRecidencyDetails.getStreetName().equalsIgnoreCase(addRecidencyDetails.getStreetName())
					&& checkRecidencyDetails.getYear().equalsIgnoreCase(addRecidencyDetails.getYear())
					&& checkRecidencyDetails.getRecidenyType().equalsIgnoreCase(addRecidencyDetails.getRecidenyType())){
				isSame=false;
			} 
			}
			return isSame;
		}

}

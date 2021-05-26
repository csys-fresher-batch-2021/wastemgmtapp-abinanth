package com.abinanth.services;



import java.util.List;

import com.abinanth.dao.RecidencyDao;
import com.abinanth.model.RecidencyModel;

public class RecidencyTypeService {

	private RecidencyTypeService() {

	}

	public static List<RecidencyModel> displayRecidencyType() {
		RecidencyDao dao = new RecidencyDao();
		List<RecidencyModel> recidencyList = dao.displayRecidency();

		return recidencyList;

	}

	public static boolean addRecidencyType(RecidencyModel newRecidency) {

		boolean valid = false;
		boolean exists = false;
		RecidencyDao dao = new RecidencyDao();
		List<RecidencyModel> recidencyTypes = dao.displayRecidency();
		for (RecidencyModel recidencyModel : recidencyTypes) {
			
		
		if (recidencyModel.getNewRecidency().equalsIgnoreCase(newRecidency.getNewRecidency())) {

			exists = true;
			break;
		}
		
		}
		
		if(!exists) {
			
			dao.addRecidency(newRecidency);
			valid = true;
		}

		return valid;

	}

	public static boolean deleteRecidencyType(RecidencyModel deleteRecidency) {
		boolean valid = false;
		RecidencyDao dao = new RecidencyDao();
		List<RecidencyModel> recidencyType = dao.displayRecidency();
		for(RecidencyModel recidency:recidencyType) {
		String deleteRecidency2 = recidency.getNewRecidency();
		if(deleteRecidency != null && deleteRecidency2.equalsIgnoreCase(deleteRecidency.getNewRecidency())) {
	
		
			valid = true;
		
		}
		

	}
		if(valid) {
			dao.deleteRecidency(deleteRecidency);
		}
		return valid;
	}

}

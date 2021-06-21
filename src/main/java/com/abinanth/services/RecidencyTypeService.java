package com.abinanth.services;

import java.util.List;
import com.abinanth.dao.RecidencyDAO;
import com.abinanth.model.RecidencyModel;
public class RecidencyTypeService {
	private RecidencyTypeService() {
		//default constructor
	}
	/*
	 * this method is used get all recidency type
	 */
	public static List<RecidencyModel> displayRecidencyType() {
		RecidencyDAO dao = new RecidencyDAO();
		return dao.findAll();
	}
/*
 * this method add the recidency type into recidencytype database
 */
	public static boolean addRecidencyType(RecidencyModel newRecidency) {
		boolean valid = false;
		boolean exists = false;
		RecidencyDAO dao = new RecidencyDAO();
		List<RecidencyModel> recidencyTypes = dao.findAll();
		for (RecidencyModel recidencyModel : recidencyTypes) {
			if (recidencyModel.getNewRecidency().equalsIgnoreCase(newRecidency.getNewRecidency())) {
				exists = true;
				break;
			}
		}
		if (!exists) {
			dao.save(newRecidency);
			valid = true;
		}
		return valid;
	}
/*
 * this method delete the recidency type
 */
	public static boolean deleteRecidencyType(RecidencyModel deleteRecidency) {
		boolean valid = false;
		RecidencyDAO dao = new RecidencyDAO();
		List<RecidencyModel> recidencyType = dao.findAll();
		for (RecidencyModel recidency : recidencyType) {
			String deleteRecidency2 = recidency.getNewRecidency();
			if (deleteRecidency != null && deleteRecidency2.equalsIgnoreCase(deleteRecidency.getNewRecidency())) {
				valid = true;
			}
		}
		if (valid) {
			dao.deleteByRecidencyType(deleteRecidency);
		}
		return valid;
	}

}

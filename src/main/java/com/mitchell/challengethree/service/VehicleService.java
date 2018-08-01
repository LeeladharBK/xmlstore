package com.mitchell.challengethree.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitchell.challengethree.dao.VehicleRepository;
import com.mitchell.challengethree.model.Fleet;
import com.mitchell.challengethree.model.Vehicle;

@Service
public class VehicleService {

	@Autowired
	VehicleRepository vehicleDao;

	@Autowired
	ValidationService service;

	public List<Vehicle> prepareLoadToDB(Fleet fleet) {

		fleet.setVehicles(service.validateVehicleFields(fleet.getVehicles()));

		service.validateSeaVehicles(fleet.getVehicles());
		service.validateLandVehicles(fleet.getVehicles());

		return loadToDB(fleet.getVehicles());
	}

	// Insert to H-2 DB using DAO
	@Transactional
	private List<Vehicle> loadToDB(List<Vehicle> vList) {
		List<Vehicle> resList = new ArrayList<>();
		for (Vehicle ve : vList) {
			resList.add(vehicleDao.save(ve));
		}
		return resList;
	}
}

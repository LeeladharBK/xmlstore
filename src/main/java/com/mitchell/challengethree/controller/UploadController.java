package com.mitchell.challengethree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitchell.challengethree.dao.VehicleRepository;
import com.mitchell.challengethree.model.Fleet;
import com.mitchell.challengethree.model.Vehicle;
import com.mitchell.challengethree.service.VehicleService;

@RestController
@RequestMapping("/v1")
public class UploadController {

	@Autowired
	VehicleService service;
	
	@Autowired
	VehicleRepository vehicleRepo;

	// upload fleet to DB and store the vehicles
	@PostMapping(path = "/upload", consumes = "application/xml")
	public List<Vehicle> postCustomer(@RequestBody Fleet fleet) {
		return service.prepareLoadToDB(fleet);
	}

	// Get all vehicles in DB
	@GetMapping(path = "/vehicles")
	public ResponseEntity<List<Vehicle>> getAllVehicles() {
		List<Vehicle> list = vehicleRepo.findAll();
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(list);
	}
}

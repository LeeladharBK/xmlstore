package com.mitchell.challengethree.service;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mitchell.challengethree.model.LandVehicle;
import com.mitchell.challengethree.model.SeaVehicle;
import com.mitchell.challengethree.model.Vehicle;

@Service
public class ValidationService {

	// validate all the vehicles for 4 common properties
	public List<Vehicle> validateVehicleFields(List<Vehicle> vehicles) {
		return vehicles.stream().filter(vehicle -> Objects.nonNull(vehicle))
				.filter(vehicle -> Objects.nonNull(vehicle.getMake()) && Objects.nonNull(vehicle.getModel())
						&& Objects.nonNull(vehicle.getYear()))
				.filter(vehicle -> !vehicle.getMake().trim().isEmpty() && !vehicle.getModel().trim().isEmpty()
						&& vehicle.getYear() > 1950)
				.collect(Collectors.toList());
		// collect the output and convert streams to a List
	}

	// validate Land Vehicles
	public void validateLandVehicles(List<Vehicle> landList) {
		validateLandVehiclesVinNumber(landList);
		validateLandVehiclesLicensePlateNumber(landList);
	}

	public void validateLandVehiclesVinNumber(List<Vehicle> landList) {
		landList.removeIf(
				vehicle -> vehicle instanceof LandVehicle && (!Objects.nonNull(((LandVehicle) vehicle).getVinNumber())
						|| (((LandVehicle) vehicle).getVinNumber().trim().length() != 17)
						|| !validateVinNumber(((LandVehicle) vehicle).getVinNumber())));
	}

	public void validateLandVehiclesLicensePlateNumber(List<Vehicle> landList) {
		landList.removeIf(vehicle -> vehicle instanceof LandVehicle
				&& (!Objects.nonNull(((LandVehicle) vehicle).getLicensePlateNumber())
						|| !(((LandVehicle) vehicle).getLicensePlateNumber().trim().length() == 7)
						|| !validateLicensePlateNumber(((LandVehicle) vehicle).getLicensePlateNumber())));

	}

	// validate Sea Vehicles
	public void validateSeaVehicles(List<Vehicle> seaList) {
		validateSeaVehiclesVinNumber(seaList);
		validateSeaVehiclesNrNumber(seaList);
	}

	public void validateSeaVehiclesVinNumber(List<Vehicle> seaList) {
		seaList.removeIf(
				vehicle -> vehicle instanceof SeaVehicle && (!Objects.nonNull(((SeaVehicle) vehicle).getVinNumber())
						|| (((SeaVehicle) vehicle).getVinNumber().trim().length() != 17)
						|| !validateVinNumber(((SeaVehicle) vehicle).getVinNumber())));

	}

	public void validateSeaVehiclesNrNumber(List<Vehicle> seaList) {
		seaList.removeIf(
				vehicle -> vehicle instanceof SeaVehicle && (!Objects.nonNull(((SeaVehicle) vehicle).getNrNumber())
						|| !(((SeaVehicle) vehicle).getNrNumber().trim().length() == 15)
						|| !validateNrNumber(((SeaVehicle) vehicle).getNrNumber())));
	}

	// validate NR Number
	public boolean validateNrNumber(String nrNumber) {
		Predicate<String> nrPattern = Pattern.compile("^[0-9]{3}\\-[0-9]{3}[a-zA-Z]{8}$").asPredicate();
		return nrPattern.test(nrNumber);
	}

	// validate VIN Number
	public boolean validateVinNumber(String vinNumber) {
		Predicate<String> vinPattern = Pattern.compile("^[a-zA-Z0-9]{9}[a-zA-Z0-9-]{2}[0-9]{6}$").asPredicate();
		return vinPattern.test(vinNumber);
	}

	// validate License Number(California)
	public boolean validateLicensePlateNumber(String licenseNumber) {
		Predicate<String> vinPattern = Pattern.compile("^[0-9]{1}[A-Z]{3}[0-9]{3}$").asPredicate();
		return vinPattern.test(licenseNumber);
	}
}

package com.mitchell.challengethree.model;

import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlElement;

@MappedSuperclass
public abstract class LandVehicle extends Vehicle {

	private String vinNumber;
	
	private String licensePlateNumber;

	@XmlElement(name = "VinNumber")
	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	@XmlElement(name = "LicensePlateNumber")
	public String getLicensePlateNumber() {
		return licensePlateNumber;
	}

	public void setLicensePlateNumber(String licensePlateNumber) {
		this.licensePlateNumber = licensePlateNumber;
	}
}

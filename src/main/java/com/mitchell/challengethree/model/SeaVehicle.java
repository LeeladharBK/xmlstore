package com.mitchell.challengethree.model;

import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlElement;

@MappedSuperclass
public abstract class SeaVehicle extends Vehicle {

	private String vinNumber;
	
	private String type;

	private String nrNumber;

	@XmlElement(name = "VinNumber")
	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	@XmlElement(name = "Type")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@XmlElement(name = "NauticalRegistrationNumber")
	public String getNrNumber() {
		return nrNumber;
	}

	public void setNrNumber(String nrNumber) {
		this.nrNumber = nrNumber;
	}
}

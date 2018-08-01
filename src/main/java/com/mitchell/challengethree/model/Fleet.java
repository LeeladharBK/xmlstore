package com.mitchell.challengethree.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Fleet")
public class Fleet {

	String nickName;

	List<Vehicle> vehicles;

	@XmlElement(name = "NickName")
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	@XmlElementWrapper(name = "Vehicles")
	@XmlElementRefs({ @XmlElementRef(name = "Bus", type = Bus.class), @XmlElementRef(name = "Boat", type = Boat.class),
			@XmlElementRef(name = "Truck", type = Truck.class),
			@XmlElementRef(name = "Motorcycle", type = MotorCycle.class) })
	public void setVehicles(List<Vehicle> vehicles1) {
		this.vehicles = vehicles1;
	}

}

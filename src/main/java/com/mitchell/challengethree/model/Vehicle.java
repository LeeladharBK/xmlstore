package com.mitchell.challengethree.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {
	@Id
	private Integer id;
	private Integer year;
	private String make;
	private String model;

	@XmlElement(name = "Id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@XmlElement(name = "Year")
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@XmlElement(name = "Make")
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@XmlElement(name = "Model")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
}

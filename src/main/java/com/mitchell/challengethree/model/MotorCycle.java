package com.mitchell.challengethree.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Motorcycle")
@Entity
@Table(name = "motorcycle")
public class MotorCycle extends LandVehicle {

}

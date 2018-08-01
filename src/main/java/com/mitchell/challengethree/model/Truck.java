package com.mitchell.challengethree.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Truck")
@Entity
@Table(name = "truck")
public class Truck extends LandVehicle {

}

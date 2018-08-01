package com.mitchell.challengethree.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Bus")
@Entity
@Table(name = "bus")
public class Bus extends LandVehicle {

}

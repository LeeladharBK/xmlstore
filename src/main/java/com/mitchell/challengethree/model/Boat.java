package com.mitchell.challengethree.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Boat")
@Entity
@Table(name = "boat")
public class Boat extends SeaVehicle {

}

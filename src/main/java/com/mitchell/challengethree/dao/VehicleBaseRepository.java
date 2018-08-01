package com.mitchell.challengethree.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitchell.challengethree.model.Vehicle;

public interface VehicleBaseRepository<T extends Vehicle> extends JpaRepository<T, Integer>{

}

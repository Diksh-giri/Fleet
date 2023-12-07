package com.hway.fleet.service;

import java.util.List;

import com.hway.fleet.model.Vehicles;

public interface VehicleService {

	void addVehicle (Vehicles vehicle);
	
	void deleteVehicle (int id);
	
	void updateVehicle (Vehicles vehicle);
	
	List<Vehicles> getAllVehicle();
	
	Vehicles getVehicleById (int id);

	List<Vehicles> getVehicleByName(String name);
	
	
}

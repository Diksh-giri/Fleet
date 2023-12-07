package com.hway.fleet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hway.fleet.model.Vehicles;
import com.hway.fleet.repository.VehicleRepository;
import com.hway.fleet.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepo;
	
	@Override
	public void addVehicle(Vehicles vehicle) {
		vehicleRepo.save(vehicle);
		
	}

	@Override
	public void deleteVehicle(int id) {
		vehicleRepo.deleteById(id);
	}

	@Override
	public void updateVehicle(Vehicles vehicle) {
		vehicleRepo.save(vehicle);		
	}

	@Override
	public List<Vehicles> getAllVehicle() {
		
		return vehicleRepo.findAll();
	}

	@Override
	public Vehicles getVehicleById(int id) {
		
		return vehicleRepo.findById(id).get();
	}

	@Override
	public List<Vehicles> getVehicleByName(String name) {
		return vehicleRepo.findByName(name);
	}

	

}

package com.hway.fleet.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hway.fleet.model.Vehicles;

public interface VehicleRepository extends JpaRepository<Vehicles, Integer>{


	    List<Vehicles> findByName(String name);
}

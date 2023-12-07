package com.hway.fleet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hway.fleet.model.Clients;

public interface ClientRepository extends JpaRepository<Clients, Integer> {

	List<Clients> findByName(String name);


}

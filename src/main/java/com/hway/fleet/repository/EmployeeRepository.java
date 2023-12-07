package com.hway.fleet.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hway.fleet.model.Employees;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

	List<Employees> findByFullName(String fullName);


}

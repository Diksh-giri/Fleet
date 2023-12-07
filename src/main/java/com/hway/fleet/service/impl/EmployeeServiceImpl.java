package com.hway.fleet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hway.fleet.model.Employees;
import com.hway.fleet.repository.EmployeeRepository;
import com.hway.fleet.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Override
	public void addEmployee(Employees employee) {
		employeeRepo.save(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepo.deleteById(id);
		
	}

	@Override
	public void updateEmployee(Employees employee) {
		employeeRepo.save(employee);
	}

	@Override
	public List<Employees> getAllEmployee() {
		
		return employeeRepo.findAll();
	}

	@Override
	public Employees getEmployeeById(int id) {

		return employeeRepo.findById(id).get();
	}

	@Override
	public List<Employees> getEmployeeByName(String fullName) {
		
		return employeeRepo.findByFullName(fullName);
	}


}

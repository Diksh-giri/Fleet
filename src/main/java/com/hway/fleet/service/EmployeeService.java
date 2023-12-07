package com.hway.fleet.service;

import java.util.List;

import com.hway.fleet.model.Employees;

public interface EmployeeService {
	
	void addEmployee (Employees employee);
	
	void deleteEmployee (int id);
	
	void updateEmployee (Employees  employee);
	
	List<Employees> getAllEmployee();
	
	Employees getEmployeeById (int id);

	List<Employees> getEmployeeByName(String fullName); 

		
	

}

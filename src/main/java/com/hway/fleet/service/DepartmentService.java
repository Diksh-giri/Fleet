package com.hway.fleet.service;

import java.util.List;
import com.hway.fleet.model.Department;

public interface DepartmentService {

	void addDepartment(Department dept);
	
	void deleteDepartment(int id);
	
	void updateDepartment(Department dept);
	
	List<Department> getAllDepartment();
	
	Department getDepartmentById(int id);
	
	List<Department> getDepartmentByName(String deptName);
}

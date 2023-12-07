package com.hway.fleet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hway.fleet.model.Department;
import com.hway.fleet.repository.DepartmentRepository;
import com.hway.fleet.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepo;
	
	@Override
	public void addDepartment(Department Department) {
		departmentRepo.save(Department);
	}

	@Override
	public void deleteDepartment(int id) {
		departmentRepo.deleteById(id);
		
	}

	@Override
	public void updateDepartment(Department Department) {
		departmentRepo.save(Department);
	}

	@Override
	public List<Department> getAllDepartment() {
		
		return departmentRepo.findAll();
	}

	@Override
	public Department getDepartmentById(int id) {

		return departmentRepo.findById(id).get();
	}

	@Override
	public List<Department> getDepartmentByName(String deptName) {

		
		return departmentRepo.findByDeptName(deptName);
	}

	
}

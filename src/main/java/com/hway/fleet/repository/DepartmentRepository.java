package com.hway.fleet.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hway.fleet.model.Department;


public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	//@Query("SELECT d FROM fleet.department-tbl d WHERE d.dept_name = :deptname")
    List<Department> findByDeptName(String deptName);
}

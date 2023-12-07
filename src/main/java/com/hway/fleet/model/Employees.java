package com.hway.fleet.model;

import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee-tbl")
public class Employees {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fullName;
	private String gender;
	private String email;
	private String phone;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dob;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate hireDate;
	private String jobTitle;
	@OneToOne
	@JoinColumn(name ="dept_id")
	private Department department;
	private int salary;
	private int age;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

}

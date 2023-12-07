package com.hway.fleet.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "vehicle-tbl")
public class Vehicles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String type;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate manufacturedate;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate acquiredate;
	@Column(columnDefinition = "longtext")
	private String description;

}

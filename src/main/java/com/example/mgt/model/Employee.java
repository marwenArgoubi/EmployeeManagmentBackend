package com.example.mgt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="employee")
public class Employee extends AbstractEntity{
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String phoneNumber;
	@NotNull
	private String employeeCode;
	
//-----N:1------/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="department_id")
	private Departement department;
}

package com.example.mgt.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="department")
public class Departement extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="departmentName")
	private String departmentName;
	@Column(name="departmentLocation")
	private String departmentLocation;
	
	//---1:N----/
	@OneToMany(mappedBy="department", fetch=FetchType.LAZY)
	private List<Employee> employees;
	
}

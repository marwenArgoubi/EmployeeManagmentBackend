package com.example.mgt.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.mgt.model.Employee;
import com.example.mgt.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements CrudService<Employee> {
@Autowired
private EmployeeRepository employeeRepo;
	@Override
	public ResponseEntity<List<Employee>> getAllelement() {
		List<Employee> employees = employeeRepo.findAll();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	@Override
	public ResponseEntity<Employee> addElement(Employee elt) {
		elt.setEmployeeCode(UUID.randomUUID().toString());
		return new ResponseEntity<>(employeeRepo.save(elt),HttpStatus.CREATED);
	}
	@Override
	public ResponseEntity<Employee> getOneElementById(Long id) {
		Optional<Employee> employee = employeeRepo.findById(id);
		return employee.map(emp->new ResponseEntity<>(emp,HttpStatus.OK)).orElseGet(()->new ResponseEntity(HttpStatus.NOT_FOUND));
		
	}
	@Override
	public ResponseEntity<HttpStatus> deleteElementById(Long id) {
		try {
			employeeRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	@Override
	public ResponseEntity<Employee> updateElement(Employee t,Long id) {
		ResponseEntity<Employee> savedEmp = getOneElementById(id);
		savedEmp.getBody().setName(t.getName());
		savedEmp.getBody().setPhoneNumber(t.getPhoneNumber());
		savedEmp.getBody().setEmail(t.getEmail());
		return new ResponseEntity<>(employeeRepo.save(savedEmp.getBody()),HttpStatus.OK);
	}
	@Override
	public ResponseEntity<List<Employee>> searchEmployee(String kw) {
		List<Employee> searchedEmployees = employeeRepo.searchEmployee("%"+kw+"%");
		return new ResponseEntity<>(searchedEmployees,HttpStatus.OK);
	}



}

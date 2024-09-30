package com.example.mgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mgt.model.Employee;
import com.example.mgt.service.CrudService;

import jakarta.validation.Valid;
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeRestController {

	@Autowired
	private CrudService<Employee> empService;
	
	@PostMapping("employee/new")
	public ResponseEntity<Employee> createEmployee(@RequestBody @Valid Employee employee){
		return empService.addElement(employee);
	}
	@GetMapping("get/employee/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		return empService.getAllelement();
	}
	@GetMapping("get/employee/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id){
		return empService.getOneElementById(id);
	}
	@GetMapping("get/employee/search")
	public ResponseEntity<List<Employee>> searchEmployee(@RequestParam(value="keyword", defaultValue="") String kw){
		return empService.searchEmployee(kw);
	}
	@PutMapping("update/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable("id") Long id){
		return empService.updateElement(employee,id);
	}
	@DeleteMapping("delete/employee/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Long id){
		return empService.deleteElementById(id);
	}
}


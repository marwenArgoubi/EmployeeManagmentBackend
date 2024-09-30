package com.example.mgt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mgt.model.Departement;
import com.example.mgt.service.CrudService;

@RestController
@RequestMapping("/api/v1/")
public class DepartmentRestController {
	@Autowired
	private CrudService<Departement> depService;
	
	@PostMapping("departement/new")
	public ResponseEntity<Departement> createEmployee(@RequestBody Departement department){
		return depService.addElement(department);
	}
	@GetMapping("get/departement/all")
	public ResponseEntity<List<Departement>> getAllEmployee(){
		return depService.getAllelement();
	}
	@GetMapping("get/departement/{id}")
	public ResponseEntity<Departement> getEmployee(@PathVariable("id") Long id){
		return depService.getOneElementById(id);
	}
	/*@PutMapping("update/departement")
	public ResponseEntity<Departement> updateEmployee(@RequestBody Departement department){
		return depService.updateElement(department);
	}*/
	@DeleteMapping("delete/departement/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Long id){
		return depService.deleteElementById(id);
	}
}

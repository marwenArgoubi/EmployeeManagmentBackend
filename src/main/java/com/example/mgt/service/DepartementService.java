package com.example.mgt.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.mgt.model.Departement;
import com.example.mgt.repository.DepartmentRepository;

@Service
public class DepartementService implements CrudService<Departement> {

	@Autowired
	private DepartmentRepository departmentRepo;
	@Override
	public ResponseEntity<List<Departement>> getAllelement() {
		List<Departement> departments = departmentRepo.findAll();
		return new ResponseEntity<>(departments,HttpStatus.OK);
	}
	@Override
	public ResponseEntity<Departement> addElement(Departement elt) {
		return new ResponseEntity<>(departmentRepo.save(elt),HttpStatus.CREATED);
	}
	@Override
	public ResponseEntity<Departement> getOneElementById(Long id) {
		Optional<Departement> departement = departmentRepo.findById(id);
		return departement.map(dept->new ResponseEntity<>(dept,HttpStatus.OK)).orElseGet(()->new ResponseEntity(HttpStatus.NOT_FOUND));
	}
	@Override
	public ResponseEntity<HttpStatus> deleteElementById(Long id) {
		try {
			departmentRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@Override
	public ResponseEntity<Departement> updateElement(Departement t,Long id) {
		return new ResponseEntity<>(departmentRepo.save(t),HttpStatus.OK);
	}
	@Override
	public ResponseEntity<List<Departement>> searchEmployee(String kw) {
		// TODO Auto-generated method stub
		return null;
	}
}
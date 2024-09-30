package com.example.mgt.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface CrudService<T> {
ResponseEntity<List<T>> getAllelement();
ResponseEntity<T> addElement(T elt);
ResponseEntity<T> getOneElementById(Long id);
ResponseEntity<HttpStatus> deleteElementById(Long id);
ResponseEntity<T> updateElement(T t,Long id);
ResponseEntity<List<T>> searchEmployee(String kw);

}

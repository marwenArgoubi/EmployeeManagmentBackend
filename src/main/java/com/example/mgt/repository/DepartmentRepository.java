package com.example.mgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mgt.model.Departement;

@Repository
public interface DepartmentRepository extends JpaRepository<Departement, Long> {

}

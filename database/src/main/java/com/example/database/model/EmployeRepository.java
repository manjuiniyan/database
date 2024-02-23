package com.example.database.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer> {

    com.example.database.services.Employe save(com.example.database.services.Employe employe);

   
}

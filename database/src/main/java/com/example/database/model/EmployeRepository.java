package com.example.database.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

    public Employe findById(int id);
    
}

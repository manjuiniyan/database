package com.example.database.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.model.EmployeRepository;

@Service
public class EmployeServices {

    private final EmployeRepository employeRepository;

    @Autowired
    public EmployeServices(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }

    public String saveEmploye(Employe employe) {
        Employe savedEmploye = employeRepository.save(employe);
        return "The saved employe id is: " + savedEmploye.getEmployeId();
    }

    
}

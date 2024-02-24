package com.example.database.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.database.model.Employe;
import com.example.database.model.EmployeRepository;

@Service
public class EmployeServices {

    @Autowired
    EmployeRepository employeRepository;

    public Employe saveEmploye(Employe employe) {
        Employe savedEmploye = employeRepository.save(employe);
        return savedEmploye;
    }

    public String findById(int id) {
        Employe employe = employeRepository.findById(id);
        return (employe != null) ? employe.toString() : "Employee not found";
    }

    public String updateEmploye(Employe employe) {
        employeRepository.save(employe);
        return "Employee details updated successfully";
    }
   
    public String deleteEmploye(int id) {
        employeRepository.deleteById(id);
        return "Employee with ID " + id + " deleted successfully";
    }
}

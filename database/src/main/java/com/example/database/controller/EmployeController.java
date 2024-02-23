package com.example.database.controller;

import com.example.database.services.EmployeServices;

import model.Employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class EmployeController {

    @Autowired
    EmployeServices employeServices;

    @GetMapping("/customer")
    public String getCustomer() {
        return "Hello From Spring Boot";
    }

    @PostMapping("saveEmploye")
    public String saveEmploye(@RequestBody com.example.database.services.Employe employe) {
        System.out.println("The Employe Name is: " + employe.getEmployeId());
        return employeServices.saveEmploye(employe);
    }
}

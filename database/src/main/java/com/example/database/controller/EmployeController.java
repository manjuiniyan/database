package com.example.database.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.database.services.EmployeServices;
import com.example.database.model.Employe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class EmployeController {

    @Autowired
    EmployeServices employeServices;
    private Employe savedEmploye;

    @GetMapping("/customer")
    public String getCustomer() {
        return "Hello From Spring Boot";
    }

    @PostMapping("/saveEmploye")
    public String saveEmploye(@RequestBody Employe employe) {
        System.out.println("Saving Employe with Name: " + employe.getEmployeName());
        employeServices.saveEmploye(employe);
        return "Employee Details Saved successfully ID is = " + savedEmploye.getEmployeId();
    }

    @GetMapping("/getCustomer")
    public String getCustomer(@RequestParam int id) {
        System.out.println("Getting employe with ID: " + id);
        employeServices.findById(id);
        return "Employee Details is Get successfully ID is =" + id ;
    }

    // create a method for updateEmploye
    @PostMapping("/updateEmploye")
    public String updateEmploye(@RequestBody Employe employe) {
        System.out.println("Updating Employe with ID = " + employe.getEmployeId());
        employeServices.updateEmploye(employe);
        return "Employee Details is Update successfully ID is = " + employe.getEmployeId();
    }
    
    // create a delete method to delete single or multiple employees by their IDs
    @PostMapping("/deleteEmploye")
    public String deleteEmploye(@RequestBody List<Integer> ids) {
        for (Integer id : ids) {
            System.out.println("Deleting employe with ID: " + id);
            employeServices.deleteEmploye(id);
        }
        return "Employee Details is Deleted successfully ID is =" + ids ;
    }

}
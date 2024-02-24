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
        savedEmploye = employeServices.saveEmploye(employe); // Assigning the returned value
        return "Employee Details Saved successfully ID is = " + savedEmploye.getEmployeId();
    }

    @GetMapping("/getEmploye")
    public String getEmploye(@RequestParam int id) {
        System.out.println("Getting employe with ID: " + id);
        return employeServices.findById(id);
    }

    @PostMapping("/updateEmploye")
    public String updateEmploye(@RequestBody Employe employe) {
        System.out.println("Updating Employe with ID = " + employe.getEmployeId());
        employeServices.updateEmploye(employe);
        return "Employee Details is Update successfully ID is = " + employe.getEmployeId();
    }
    
    @PostMapping("/deleteEmploye")
    public String deleteEmploye(@RequestBody List<Integer> ids) {
        for (Integer id : ids) {
            System.out.println("Deleting employe with ID: " + id);
            employeServices.deleteEmploye(id);
        }
        return "Employee Details is Deleted successfully ID is =" + ids ;
    }

}

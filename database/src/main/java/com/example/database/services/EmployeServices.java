
package com.example.database.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.database.model.Employe;
import com.example.database.model.EmployeRepository;

@Service
public class EmployeServices {

    @Autowired
    EmployeRepository employeRepository;

    public String saveEmploye(Employe employe) {
        Employe savedEmploye = employeRepository.save(employe);
        return "The saved employe id is: " + savedEmploye.getEmployeId();
    }

    public String findById(int id) {
        return "The saved employe id is: " + employeRepository.findById(id);
    }
    //create a methed for updateEmploye
    public String updateEmploye(Employe employe) {
        return "the updated employe id is: " + employeRepository.save(employe);
    }
   
    
    //create a delete method with return type
    public String deleteEmploye(int id) {
        employeRepository.deleteById(id);
        return "the deleted employe id is: " + id;
    }
    
    

}
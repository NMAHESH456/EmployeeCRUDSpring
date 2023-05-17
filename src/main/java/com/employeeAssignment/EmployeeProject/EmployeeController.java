package com.employeeAssignment.EmployeeProject;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Transactional
@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepo employeeRepo;

    @PostMapping("/employee")
    //public Employee saveEmployee(Employee employee){
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity< >(employeeRepo.save(employee), HttpStatus.OK);
    }

    //get all employees
    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getEmployees() {
        return new ResponseEntity<>(employeeRepo.findAll(), HttpStatus.OK);
    }

    //get individual id
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            return new ResponseEntity<>(employee.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee emp) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            employee.get().setEmployeeName(emp.getEmployeeName());
            employee.get().setEmployeeEmail(emp.getEmployeeEmail());
            employee.get().setEmployeeRole(emp.getEmployeeRole());
            return new ResponseEntity<>(employeeRepo.save(employee.get()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            employeeRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

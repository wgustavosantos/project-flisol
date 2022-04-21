package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return service.findAll();
    }

    // build create employee REST API
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return service.createEmployee(employee);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable  long id){       
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails) {

        return ResponseEntity.ok(service.updateEmployee(id, employeeDetails));
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        service.deleteEmployee(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}

package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;
	
	public List<Employee> findAll (){
		return repository.findAll();
	}
	
	public Employee createEmployee (Employee employee) {
		return repository.save(employee);
	}
	
	public Employee getEmployeeById (long id){
		
		Employee employee = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
		return employee;
	}
	
	public Employee updateEmployee(long id, Employee employee) {
		Employee empl = repository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: " + id));
		
		empl.setId(id);
		empl.setFirstName(employee.getFirstName());
		empl.setLastName(employee.getLastName());
		empl.setEmailId(employee.getEmailId());
		
		return repository.save(empl);
	}
	
	public void deleteEmployee(long id) {
		
		Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: " + id));
		repository.delete(employee);
	}

}

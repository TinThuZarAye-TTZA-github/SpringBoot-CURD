package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository repo;

	//Get All Employee
	@Override
	public List<Employee> getAll() {
		List<Employee> elist = repo.findAll();
		return elist;
	}
	
	// Post new employee
	@Override
	public Employee postEmployee(Employee e) {
		repo.save(e);
		System.out.println("Data Inserted");
		return e;
	}

	// get employee by id
	@Override
	public Optional<Employee> getById(int id) {
		return repo.findById(id);
	}

	
	// update employee with id
	@Override
	public Employee updateEmployeeById(Employee newEmployee, int id) {
		
		return repo.findById(id)
				.map(e -> {
					e.setEmployee_name(newEmployee.getEmployee_name());
					e.setStreet(newEmployee.getStreet());
					e.setCity(newEmployee.getCity());
					return repo.save(e);
					
				})
				.orElseGet(() -> {
					newEmployee.setEmp_id(id);
					return repo.save(newEmployee);
				})
				;
	}

	// delete employee with id
	@Override
	public void deleteEmployeeWithId(int id) {
		repo.deleteById(id);
		
	}
	

}
	

	



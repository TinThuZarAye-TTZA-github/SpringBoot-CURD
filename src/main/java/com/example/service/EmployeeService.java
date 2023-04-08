package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Employee;

public interface EmployeeService {
	List<Employee> getAll();
	
	public Employee postEmployee(Employee e);
	
	Optional<Employee> getById(int id);
	
	public Employee updateEmployeeById(Employee newEmployee, int id);
	
	public void deleteEmployeeWithId(int id);
	
}

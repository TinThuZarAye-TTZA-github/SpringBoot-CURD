package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	//Get All Employee
	@RequestMapping("/employee")
	@ResponseBody
	List<Employee> getAllEmployee() {
		return service.getAll();
	}
	
	// Post New Employee
	@PostMapping("/employee")
	@ResponseBody
	Employee postEmployee(@RequestBody Employee newEmployee) {
		return service.postEmployee(newEmployee);
	}
	
	// Get the employee by id
	@GetMapping(value="/employee/{id}")
	@ResponseBody
	Optional<Employee> getById(@PathVariable("id") int id) {
		return service.getById(id);
	}
	
	// updated employee with id
	@PutMapping("/employee/{id}")
	@ResponseBody
	Employee updateEmployeeWithId(@RequestBody Employee newEmployee, @PathVariable("id") int id) {
		return service.updateEmployeeById(newEmployee, id);
	}
	
	//delete employee with id
	@DeleteMapping("/employee/{id}")
	@ResponseBody
	void deleteEmployeeWithId(@PathVariable("id") int id) {
		service.deleteEmployeeWithId(id);
	}
}

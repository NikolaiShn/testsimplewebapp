package com.mastery.java.task.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;

@RestController
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.loadAll();
	}
	
	@PostMapping
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.insert(employee);
	}
	
	@PutMapping
	public void updateEmployee(@RequestBody Employee employee) {
		employeeService.update(employee);
	}
	
	@GetMapping("{id}")
	Employee getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}
	
	@DeleteMapping("{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeService.delete(id);
	}
}

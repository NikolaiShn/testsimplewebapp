package com.mastery.java.task.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Repeat;
import org.springframework.test.context.junit4.SpringRunner;

import com.mastery.java.task.config.AppConfiguration;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import com.mastery.java.task.service.exceptions.EmptyResultDataAccessException;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppConfiguration.class)
public class EmployeeServiceTest {
	
	@Autowired 
	EmployeeService employeeService; 
	 
	@Test
	@Repeat(20)
	 public void TestServiceGetEmployeeById() {
		Employee employee = new Employee(21L, "Ivan", "Pupkin", 0, "Driver", Gender.MALE, "2000-06-08");
		 assertEquals(employee.getFirstName(), employeeService.getEmployeeById(21L).getFirstName());
		 assertEquals(employee.getLastName(), employeeService.getEmployeeById(21L).getLastName());
		 assertEquals(employee.getJobTitle(), employeeService.getEmployeeById(21L).getJobTitle());
		 assertEquals(employee.getDepartmentId(), employeeService.getEmployeeById(21L).getDepartmentId());
		 assertEquals(employee.getGender(), employeeService.getEmployeeById(21L).getGender());
		 assertEquals(employee.getDateOfBirth(), employeeService.getEmployeeById(21L).getDateOfBirth());
	 }
	
	@Test
	@Repeat(20)
	public void TestServiceUpDate() {
		Employee employee = new Employee(24L, "Ivan", "Pupkin", 0, "Driver", Gender.MALE, "2000-06-08");
		employeeService.update(employee);
		Employee updateemployee = employeeService.getEmployeeById(24L);
		assertEquals(employee.getFirstName(), updateemployee.getFirstName());
		assertEquals(employee.getLastName(), updateemployee.getLastName());
		assertEquals(employee.getJobTitle(), updateemployee.getJobTitle());
		assertEquals(employee.getDepartmentId(), updateemployee.getDepartmentId());
		assertEquals(employee.getGender(), updateemployee.getGender());
		assertEquals(employee.getDateOfBirth(), updateemployee.getDateOfBirth());
	 }
	
	@Test
	public void TestServiceDelete() {
		employeeService.delete(5L);
		assertEquals(null, employeeService.getEmployeeById(5L));
	}	
}

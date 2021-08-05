package com.mastery.java.task.dao;

import java.util.List;



import com.mastery.java.task.dto.Employee;


public interface DaoDbFunctions {
	void insert(Employee employee);
	void delete(long id);
	void update(Employee employee);
	List<Employee> loadAllEmployees();
	Employee findEmployeeById(long employee_id);
	boolean existEmployee(Employee employee);
	boolean existEmployee(long id);
}

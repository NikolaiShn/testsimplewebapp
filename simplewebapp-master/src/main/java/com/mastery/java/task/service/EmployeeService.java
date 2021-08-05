package com.mastery.java.task.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastery.java.task.dao.DaoDbFunctions;
import com.mastery.java.task.dto.Employee;

@Service
public class EmployeeService {
	@Autowired
	DaoDbFunctions n;
	
	public void insert(Employee employee) {
		if(n.existEmployee(employee)) {
			System.out.println("Exists in the db");
		}else {
			if(check(employee)) {
				n.insert(employee);
			}else {
				System.out.println("Invalid format");
			}
		}
		
	}
	
	public void delete(Long id) {
		if(n.existEmployee(id)) {
		n.delete(id);
		}else {
			System.out.println("Employee not exists in the db");
		}
	}
	
	public void update(Employee employee) {
		if(n.existEmployee(employee)&&check(employee)) {
			n.update(employee);
		}else {
			System.out.println("Employee not exists in the db or Invalid format");
		}
	}
	
	public List<Employee> loadAll() {
		List<Employee> allEmployee = n.loadAllEmployees();
		return allEmployee;
	}
	
	public Employee getEmployeeById(Long id) {
		if(n.existEmployee(id)) {
			return n.findEmployeeById(id);
		}else {
			System.out.println("Employee not exists in the db");
			return null;
		}
	}
	//check gender, date_of_birth 
	private boolean check(Employee employee) {
		boolean validDate = validDate(employee.getDateOfBirth(), "yyyy-MM-dd");
		boolean validGender = (employee.getGender() != null);
		if(validDate&&validGender){
			return true;
		}else {
			return false;
		}
	}
	//check date format
	private boolean validDate(String s, String pattern) {    
			 SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			 if(s == null || s.trim().equals("")){
				 //check
			     return false;
			 }
	         try {
	             return sdf.format(sdf.parse(s)).equals(s);
	         }
	        	 catch (Exception e){	        
	        		return false;
	         }
	}
}

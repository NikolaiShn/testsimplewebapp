package com.mastery.java.task.service;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastery.java.task.dao.DaoDbFunctions;
import com.mastery.java.task.service.exceptions.EmptyResultDataAccessException;
import com.mastery.java.task.service.exceptions.ExistsEmployeeException;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.exceptions.InvalidFormatException;

@Service
public class EmployeeService {
	@Autowired
	DaoDbFunctions n;
	
	public void insert(Employee employee) {
		if(n.existEmployee(employee)) {
			throw new ExistsEmployeeException();
		}else {
			if(check(employee)) {
				n.insert(employee);
			}
		}
	}
	
	public void delete(Long id) {
		if(n.existEmployee(id)) {
			n.delete(id);
		}else {
			throw new EmptyResultDataAccessException();
		}
	}
	
	public void update(Employee employee) {
		if(n.existEmployee(employee)&&check(employee)) {
			n.update(employee);
		}else {
			throw new EmptyResultDataAccessException();
		}
	}
	
	public List<Employee> loadAll(){
		List<Employee> allEmployee = n.loadAllEmployees();
		return allEmployee;
	}
	
	public Employee getEmployeeById(Long id){
		if(n.existEmployee(id)) { 
			return n.findEmployeeById(id);
		}else {
			throw new EmptyResultDataAccessException();
		}
	}
	//check gender, date_of_birth 
	private boolean check(Employee employee) {
		boolean validDate = validDate(employee.getDateOfBirth(), "yyyy-MM-dd");
		boolean validGender = (employee.getGender() != null);
		if(validDate&&validGender){
			return true;
		}else {
			throw new InvalidFormatException();
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

package com.mastery.java.task.dao;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.SQLException;
import java.sql.ResultSet;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;


@Repository
public class EmployeeDao implements DaoDbFunctions{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public void insert(Employee employee){
		String sql = "INSERT INTO employee " +
					"(first_name, last_name, department_id, job_title, gender, date_of_birth) "
					+ "VALUES ("
					   + "'" + employee.getFirstName() + "',"
					   + "'" + employee.getLastName() + "',"
					   + "'" + employee.getDepartmentId() + "',"
					   + "'" + employee.getJobTitle() + "',"
					   + "'" + employee.getGender().toString() + "',"
					   + "'" + employee.getDateOfBirth() + "');";
		this.jdbcTemplate.update(sql);
			
	}
	
	public void delete(long id) {
		//delete
		String sql = "DELETE FROM employee WHERE employee_id =" + id;
		this.jdbcTemplate.update(sql);
	}

	@Override
	public void update(Employee employee){
		String sql = "UPDATE employee " +
						"SET " 
						   + " first_name = '" + employee.getFirstName() + "',"
						   + " last_name = '" + employee.getLastName() + "',"
						   + " department_id = '" + employee.getDepartmentId() + "',"
						   + " job_title = '" + employee.getJobTitle() + "',"
						   + " gender = '" + employee.getGender().toString() + "',"
						   + " date_of_birth = '" + employee.getDateOfBirth() +"'"
						   + "WHERE employee_id = '" + employee.getEmployeeId() + "'";
		this.jdbcTemplate.update(sql);
	}
	
	@Override
	public List<Employee> loadAllEmployees() {
		String sql = "SELECT * FROM employee";
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(sql);
		
		List<Employee> result = new ArrayList<Employee>();
		for(Map<String, Object> row: rows){
			Employee employee = new Employee();
			employee.setEmployeeId((Long)row.get("employee_id"));
			employee.setFirstName(row.get("first_name").toString());
			employee.setLastName(row.get("last_name").toString());
			employee.setDepartmentId((int)row.get("department_id"));
			employee.setJobTitle(row.get("job_title").toString());
			employee.setGender(Gender.valueOf((String) row.get("gender")));
			employee.setDateOfBirth(row.get("date_of_birth").toString());
			result.add(employee);
		}
			return result;
		}
	
	@Override
	public Employee findEmployeeById(long employee_id) {
		String sql = "SELECT * FROM employee WHERE employee_id=" + employee_id;
			return  this.jdbcTemplate.queryForObject(sql, new RowMapper<Employee>() {
			//check
			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee employee = new Employee();
				employee.setEmployeeId(rs.getLong("employee_id"));
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString("last_name"));
				employee.setDepartmentId(rs.getInt("department_id"));
				employee.setJobTitle(rs.getString("job_title"));
				employee.setGender(Gender.valueOf((String)rs.getObject("gender")));
				employee.setDateOfBirth(rs.getDate("date_of_birth").toString());
				return employee;
			}
		});
	}
	
	//check exist Employee 
	@Override
	public boolean existEmployee(Employee employee) {
		String sqlcheck = "select exists(select 1 from employee where employee_id=" + employee.getEmployeeId() + ")";
		if (this.jdbcTemplate.queryForObject(sqlcheck, Boolean.class)) {
			return true;
		}else {
			return false;
		}
	}
	//check exist Employee by id 
	@Override
	public boolean existEmployee(long id) {
		String sqlcheck = "select exists(select 1 from employee where employee_id=" + id + ")";
		if (this.jdbcTemplate.queryForObject(sqlcheck, Boolean.class)) {
			return true;
		}else {
			return false;
		}
	}
}

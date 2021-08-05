
package com.mastery.java.task.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import com.mastery.java.task.service.EmployeeService;

@SpringBootApplication
@ComponentScan("com.mastery.java.task.rest, com.mastery.java.task.service, com.mastery.java.task.dao")
public class AppConfiguration {
	
	@Autowired
	EmployeeService service;
	
	public static void main(String[] args) {
		SpringApplication.run(AppConfiguration.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames(); 
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
			Employee e1 = new Employee();
			Employee e2 = new Employee();
			
			e1.setFirstName("Valera");
			e1.setGender(Gender.MALE);
			e1.setDateOfBirth("2000-06-08");
			service.insert(e1);
			e2.setFirstName("Victoria");
			e2.setGender(Gender.FEMALE);
			e2.setDateOfBirth("2000-06-08");
			service.insert(e2);
			service.loadAll();
		};
	}
}
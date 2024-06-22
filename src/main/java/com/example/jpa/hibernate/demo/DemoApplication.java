package com.example.jpa.hibernate.demo;

import com.example.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.example.jpa.hibernate.demo.entity.PartTimeEmployee;
import com.example.jpa.hibernate.demo.repository.CourseRepository;
import com.example.jpa.hibernate.demo.repository.EmployeeRepository;
import com.example.jpa.hibernate.demo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		employeeRepository.insert(new FullTimeEmployee("Jack",new BigDecimal("10000")));
		employeeRepository.insert(new PartTimeEmployee("Jill",new BigDecimal("50")));
		logger.info("all employees ->{}",employeeRepository.retrieveAllEmployees());

	}
}

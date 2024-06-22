package com.example.jpa.hibernate.demo.repository;

import com.example.jpa.hibernate.demo.DemoApplication;
import com.example.jpa.hibernate.demo.entity.Address;
import com.example.jpa.hibernate.demo.entity.Passport;
import com.example.jpa.hibernate.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class StudentRepositoryTest {
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	StudentRepository courseRepository;
	@Autowired
	EntityManager em;

	@Test
	@Transactional
	public void retrieveStudentAndPassport() {
		Passport passport=em.find(Passport.class,40001);
		Student student =em.find(Student.class, 20001);
		logger.info("student ->{}",student);
		logger.info("passport ->{}",student.getPassport());
		// same as the first one we were able to do this bcuz of bidirectional 1to 1 relation
		logger.info("student ->{}",passport.getStudent());

	}
	@Test
	@Transactional
	public void setAddressDetailsTest() {
		Student student =em.find(Student.class, 20001);
		student.setAddress(new Address("No 101","some street","london"));
		em.flush();
		logger.info("student ->{} {}",student,student.getAddress().toString());

	}
}

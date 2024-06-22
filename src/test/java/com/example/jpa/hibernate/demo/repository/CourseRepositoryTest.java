package com.example.jpa.hibernate.demo.repository;

import com.example.jpa.hibernate.demo.DemoApplication;

import com.example.jpa.hibernate.demo.entity.Course;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class CourseRepositoryTest {
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepository courseRepository;

	@Test
	public void findByIdTest() {
		Course course = courseRepository.findById(10001);
		assertEquals("jpa course",course.getName());
	}
	@Test
	public void findByIdTest_FirstLevelCache() {
		Course course = courseRepository.findById(10001);
		logger.info("First course retrieve {}",course);
		//hibernate doesnt execute findbyid again it is cached in the first one
		Course course2 = courseRepository.findById(10001);
		logger.info("First course retrieve {}",course2);
		assertEquals("JPA Course",course.getName());
		assertEquals("JPA Course",course2.getName());
	}
	@Test
	@DirtiesContext
	public void deleteByIdTest() {
		courseRepository.deleteById(10002);
		assertNull(courseRepository.findById(10002));
	}
	@Test
	@DirtiesContext
	public void saveTest() {
		courseRepository.save(new Course("jpa course updated",10001L));
		assertEquals("jpa course updated",courseRepository.findById(10001).getName());

	}
	@Test
	@DirtiesContext
	public void playTest(){
		courseRepository.playWithEntityManager();
	}


}

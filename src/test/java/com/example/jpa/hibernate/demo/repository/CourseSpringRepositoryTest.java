package com.example.jpa.hibernate.demo.repository;

import com.example.jpa.hibernate.demo.DemoApplication;
import com.example.jpa.hibernate.demo.entity.Course;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class CourseSpringRepositoryTest {
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseSpringRepository courseSpringRepository;

	@Test
	public void findByIdCoursePresent(){
		Optional<Course> courseOptional = courseSpringRepository.findById(10001L);
		assertTrue(courseOptional.isPresent());
		logger.info("{}",courseOptional);
	}
	@Test
	public void findByIdCourseNotPresent(){
		Optional<Course> courseOptional = courseSpringRepository.findById(30001L);
		assertTrue(courseOptional.isPresent());
		logger.info("{}",courseOptional);
	}
	@Test
	public void sort(){
		Sort sort = Sort.by(Sort.Direction.DESC, "name");
		logger.info("sorted courses ->{}",courseSpringRepository.findAll(sort));
		logger.info("query ->{}",courseSpringRepository.course());

	}
	@Test
	public void pagination(){
		PageRequest pageRequest= PageRequest.of(0,2);
		Page<Course> page = courseSpringRepository.findAll(pageRequest);
		logger.info("pagination ->{}",page.getContent());
	}

	@Test
	public void playingAround(){
		Course course =new Course("Microservices in 100 steps");
		courseSpringRepository.save(course);
		course.setName("Microservices in 100 steps updated");
		courseSpringRepository.save(course);
		//second save updates does not add new row
		logger.info("count ->{}",courseSpringRepository.count());
	}


}

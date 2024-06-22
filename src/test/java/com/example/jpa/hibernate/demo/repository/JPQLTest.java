package com.example.jpa.hibernate.demo.repository;

import com.example.jpa.hibernate.demo.DemoApplication;
import com.example.jpa.hibernate.demo.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class JPQLTest {
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;

	@Test
	public void jpqlTest() {
		List resultList = em.createQuery("select c from Course c").getResultList();
		logger.info("resultList: ->{}",resultList);
	}

	@Test
	public void jpqlTypedTest() {
		TypedQuery<Course> query =em.createQuery("select c from Course c", Course.class);
		List resultList = query.getResultList();
		logger.info("resultList: ->{}",resultList);
	}
	@Test
	public void jpql_Where_Test() {
		TypedQuery<Course> query =em.createQuery("select c from Course c where name like'%100 steps'", Course.class);
		List resultList = query.getResultList();
		logger.info("resultList: ->{}",resultList);
	}
}

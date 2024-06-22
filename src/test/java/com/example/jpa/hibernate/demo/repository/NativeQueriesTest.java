package com.example.jpa.hibernate.demo.repository;

import com.example.jpa.hibernate.demo.DemoApplication;
import com.example.jpa.hibernate.demo.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
class NativeQueriesTest {
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;

	@Test
	public void nativeQueriesTest() {
		Query query=em.createNativeQuery("select * from Course where id=? ", Course.class);
		query.setParameter(1,1);
		List resultList = query.getResultList();
		logger.info("resultList: ->{}",resultList);
	}
	public void nativeQueriesParameterTest() {
		Query query=em.createNativeQuery("select * from Course where id=:id ", Course.class);
		query.setParameter("id" ,1);
		List resultList = query.getResultList();
		logger.info("resultList: ->{}",resultList);
	}

}

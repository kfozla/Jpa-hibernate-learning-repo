package com.example.jpa.hibernate.demo.repository;

import com.example.jpa.hibernate.demo.entity.Course;
import com.example.jpa.hibernate.demo.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CourseRepository {
    @Autowired
    EntityManager em;
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    public Course findById(long id){
        return em.find(Course.class,id);
    }
    public void deleteById(long id){
        em.remove(findById(id));
    }
    public Course save(Course course){
        if (course.getId() == null){
            em.persist(course);
        }
        else {
            em.merge(course);
        }
        return course;
    }
    public void playWithEntityManager(){
        Course course =new Course("web services in 100 steps");
        Course course2 = new Course("angular in 100 steps");
        em.persist(course);
        em.persist(course2);

        em.flush();

        course.setName("web services in 100 steps updated");
        course2.setName("angular in 100 steps updated");
        em.refresh(course);
        em.flush();
    }
    public void addReviewForCourse(){
        Course course=findById(10003);
        logger.info("Reviews for course 10003->{}",course.getReviews());
        Review review=new Review("5","Great Stuff");
        Review review2=new Review("2","Hands off");

        course.addReview(review);
        review.setCourse(course);

        course.addReview(review2);
        review2.setCourse(course);

        em.persist(review);
        em.persist(review2);
    }
    public void addReviewForCourse(Long id, List<Review>reviews){
        Course course= findById(id);
        for (Review review:reviews){
            course.addReview(review);
            review.setCourse(course);

            em.persist(review);
        }
    }
}

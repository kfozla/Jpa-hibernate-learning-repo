package com.example.jpa.hibernate.demo.repository;

import com.example.jpa.hibernate.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource(path = "courses")
public interface CourseSpringRepository extends JpaRepository<Course,Long> {
    @Query("Select c From Course c where name like'%Boot course'")
    List<Course> course();

}

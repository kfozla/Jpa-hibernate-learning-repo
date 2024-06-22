package com.example.jpa.hibernate.demo.repository;

import com.example.jpa.hibernate.demo.entity.Passport;
import com.example.jpa.hibernate.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentRepository {
    @Autowired
    EntityManager em;
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    public Student findById(long id){
        return em.find(Student.class,id);
    }
    public void deleteById(long id){
        em.remove(findById(id));
    }
    public Student save(Student student){
        if (student.getId() == null){
            em.persist(student);
        }
        else {
            em.merge(student);
        }
        return student;
    }
    public void saveStudentWithPassport(){
        Passport passport=new Passport("Z123");
        em.persist(passport);

        Student student =new Student("Mike");
        student.setPassport(passport);
        em.persist(student);

    }
}

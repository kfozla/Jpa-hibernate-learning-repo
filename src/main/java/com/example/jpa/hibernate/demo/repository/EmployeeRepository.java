package com.example.jpa.hibernate.demo.repository;

import com.example.jpa.hibernate.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {
    @Autowired
    EntityManager em;
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    public void insert (Employee employee){
        em.persist(employee);
    }
    public List<Employee> retrieveAllEmployees(){
        return em.createQuery("select e from Employee e",Employee.class).getResultList();
    }
}

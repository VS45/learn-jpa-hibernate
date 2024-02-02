package com.vs45tech.springboot.learnjpahibernate.course.jpa;

import org.springframework.stereotype.Repository;

import com.vs45tech.springboot.learnjpahibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
    @PersistenceContext
    private EntityManager em;

    public void insert(Course course){
        em.merge(course);
    }
    public Course findById(long id){
return em.find(Course.class, id);
    }
    public void deleteById(long id){
Course course= em.find(Course.class, id);
if(course!=null){
    em.remove(course);
}
    }
}

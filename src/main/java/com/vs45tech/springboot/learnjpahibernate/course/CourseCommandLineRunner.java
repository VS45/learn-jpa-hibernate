package com.vs45tech.springboot.learnjpahibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//import com.vs45tech.springboot.learnjpahibernate.course.jdbc.CourseJdbcRepository;
//import com.vs45tech.springboot.learnjpahibernate.course.jpa.CourseJpaRepository;
import com.vs45tech.springboot.learnjpahibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{
    /* @Autowired
    private CourseJdbcRepository repository;
 */
   /*  @Autowired
    private CourseJpaRepository repository;
 */
@Autowired
    private CourseSpringDataJpaRepository repository;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Executing...");
        repository.save(new Course(1,"Learn Go Programming Spring Data JPA","VS45 Tech"));
        repository.save(new Course(2,"Learn AWS Spring Data JPA","VS45 Tech"));
        repository.save(new Course(3,"Learn DevOps Spring Data JPA","VS45 Tech"));
        repository.deleteById(1l);
        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));
       System.out.println(repository.findAll());
       System.out.println(repository.count());
       System.out.println(repository.findByAuthor("VS45 Tech"));
       System.out.println(repository.findByAuthor(""));
    }

}

package com.vs45tech.springboot.learnjpahibernate.course.jdbc;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vs45tech.springboot.learnjpahibernate.course.Course;

@Repository
public class CourseJdbcRepository {

@Autowired   
private JdbcTemplate springJdbcTemplate;

private static String INSERT_QUERY= 
        """
        insert into course(id,title,author)
        values(?,?,?);
        """;
private static String DELETE_QUERY= 
        """
        DELETE course
        WHERE id=?;
        """;
private static String SELECT_SINGLE_QUERY= 
        """
        SELECT * FROM course WHERE id=?;
        """;
private static String SELECT_QUERY= 
        """
        SELECT * FROM course;
        """;

public void insert(Course course){
    springJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getTitle(),course.getAuthor());
}
public void delete(long id){
    springJdbcTemplate.update(DELETE_QUERY,id);
}
public Course findById(long id){
    return springJdbcTemplate.queryForObject(SELECT_SINGLE_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
}public List<Course> findAll() {
    List<Course> courses = springJdbcTemplate.query(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class));
    return courses != null ? courses : Collections.emptyList();
}
}


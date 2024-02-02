package com.vs45tech.springboot.learnjpahibernate.course;
//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
private long id;
// @Column(name="title") not needed for field name is the same with column name 
private String title;
/* @Column(name="author") not needed for field name is the same with column name */
private String author;
public Course(){}
public Course(long id, String title, String author) {
    super();
    this.id = id;
    this.title = title;
    this.author = author;
}
public long getId() {
    return id;
}
public void setId(long id) {
    this.id = id;
}
public String getTitle() {
    return title;
}
public void setTitle(String title) {
    this.title = title;
}
public String getAuthor() {
    return author;
}
public void setAuthor(String author) {
    this.author = author;
}
@Override
public String toString() {
    return "Course [id=" + id + ", title=" + title + ", author=" + author + "]";
}

}

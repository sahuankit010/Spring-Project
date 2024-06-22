package com.springrest.springrest.service;

import com.springrest.springrest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements  CourseService{

    List<Course> courses;

    public  CourseServiceImpl(){
        courses = new ArrayList<>();

        courses.add(new Course(101, "Mathematics", "A basic mathematics course"));

        courses.add(new Course(6301, "IDSA",
                "Implementation of Data Structure and Algorithm"));
        courses.add(new Course(6375, "ML", "Machine Learning"));
    }
    @Override
    public List<Course> getCourses() {
        return courses;
    }
    @Override
    public Course getCourse(long id){

        for(Course c: courses){
            if(c.getId() == id) return c;
        }
        return new Course(-1, null, null);
    }

    @Override
    public Course addCourse(Course c) {
        courses.add(c);
        return c;
    }

    @Override
    public Course updateCourse(Course course) {
        for(Course c: courses){
            if(c.getId() == course.getId()){
                c.setTitle(course.getTitle());
                c.setDescription(course.getDescription());
                return course;
            }
        }
        return new Course(-1,  null, null);
    }

    @Override
    public boolean deleteCourse(long l) {
        for(Course c: courses){
            if(c.getId() == l) {
                courses.remove(c);
                return true;
            }
        }
        return false;
    }
}

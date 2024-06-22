package com.springrest.springrest.service;

import com.springrest.springrest.entities.Course;

import java.util.List;

public interface CourseService {

    List<Course> getCourses();
    Course getCourse(long id);

    Course addCourse(Course c);

    Course updateCourse(Course course);

    boolean deleteCourse(long l);
}

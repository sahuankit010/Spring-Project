package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private CourseServiceImpl courseServiceImpl;
    public MyController(){
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseServiceImpl.getCourses();
    }
    @GetMapping("/courses/{id}")
    public Course getCourse(@PathVariable String id){
        return this.courseServiceImpl.getCourse(Long.parseLong(id));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course c){
        System.out.println(c);
        System.out.println("Post Mapping");
        return this.courseServiceImpl.addCourse(c);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseServiceImpl.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity deleteCourse(@PathVariable String courseId){
        try{
            if(this.courseServiceImpl.deleteCourse(Long.parseLong(courseId))){
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

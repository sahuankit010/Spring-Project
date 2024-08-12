package com.springrest.springrest.controller;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api")
public class MyController {

    @Autowired
    private CourseDao courseDao;

    public MyController() {
    }

    @Tag(name = "get", description = "GET method of courses APIs")
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseDao.findAll();
    }
    @Tag(name = "get", description = "GET method of particular course API")
    @GetMapping("/courses/{id}")
    public Optional<Course> getCourse(@Parameter(
            description = "ID of course to be retrieved",
            required = true)@PathVariable String id) {
        try{
            System.out.println(id);
            return this.courseDao.findById(Long.parseLong(id));

        } catch(Exception e){
            System.out.println("Error\n" + e);
            return Optional.of(new Course(-1, "", ""));
        }
    }
    @Tag(name = "post", description = "POST methods of courses APIs")
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course c) {
        try {
            System.out.println(c);
            System.out.println("Post Mapping");
            this.courseDao.save(c);
            return c;
        } catch(Exception e){
            System.out.println(e);
            return new Course(-1, "", "");
        }

    }
    @Operation(summary = "Update a course",
            description = "Update an existing employee. The response is updated Course object with id, title, and description.")
    @Tag(name = "put", description = "PUT method of courses APIs")
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        try {
            this.courseDao.save(course);
            return course;
        } catch(Exception e){
            System.out.println(e);
            return new Course(-1, "", "");
        }
    }
    @Tag(name = "delete", description = "DELETE method of courses APIs")
    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity deleteCourse(@PathVariable String courseId) {
        Course entity = this.courseDao.getOne(Long.parseLong(courseId));
        try {
            if (entity != null) {
                this.courseDao.delete(entity);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}

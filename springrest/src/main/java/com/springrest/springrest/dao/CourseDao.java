package com.springrest.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springrest.springrest.entities.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<Course, Long>{

}

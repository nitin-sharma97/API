package com.rest.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.api.entities.Course;

@Repository
public interface CourseDao extends JpaRepository<Course, Long> {

}

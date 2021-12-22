package com.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.api.entities.Course;
import com.rest.api.services.CourseServices;

@RestController
public class MyController {
	
	@Autowired
	private CourseServices courseServices;
	
	@GetMapping("/course")
	public List<Course> getAll(){
		return courseServices.getList(); 
	}
	
	@GetMapping("/course/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseServices.getCourse(Long.parseLong(courseId));
	}
	
	
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		
		return this.courseServices.addCourse(course);
		
	}
	
	@PutMapping("/course")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseServices.updateCourse(course);
	}
	
	@DeleteMapping("/course/{courseId}")
	public void deleteCourse(@PathVariable String courseId) {
		courseServices.deleteCourse(Long.parseLong(courseId));
	}

}

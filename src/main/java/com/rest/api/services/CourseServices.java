package com.rest.api.services;

import java.util.List;

import com.rest.api.entities.Course;

public interface CourseServices {

	public List<Course> getList();
	
	public Course getCourse(long courseId);
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public void deleteCourse(long courseId);
	
}

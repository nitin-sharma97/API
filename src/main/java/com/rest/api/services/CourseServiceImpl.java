package com.rest.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.api.dao.CourseDao;
import com.rest.api.entities.Course;
@Service
public class CourseServiceImpl implements CourseServices {

	@Autowired
	private CourseDao courseDao;
	
	@Override
	public List<Course> getList() {
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		
		return courseDao.getById(courseId) ;
		
//		Optional<Course> findById = courseDao.findById(courseId);
//		return findById.get();
	}

	@Override
	public Course addCourse(Course course) {
		 courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		courseDao.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long courseId) {
		Course entity = courseDao.getById(courseId);
		courseDao.delete(entity);
	}

}

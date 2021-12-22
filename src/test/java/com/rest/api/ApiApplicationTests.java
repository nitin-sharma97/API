package com.rest.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.rest.api.dao.CourseDao;
import com.rest.api.entities.Course;
import com.rest.api.services.CourseServices;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ApiApplicationTests {

	@Autowired
  private CourseServices courseServices;
	
	@MockBean
   private	CourseDao courseDao;

	@Test
	public void  getUserTest() {
		when(courseDao.findAll()).thenReturn(Stream.of(new Course(376,"Java","This is java course"),new Course(377,"Python","This is Python Course")).collect(Collectors.toList()));
		assertThat(2).isEqualTo(courseServices.getList().size());
		
	}
	
	@Test
	public void getCourse() {
		long  courseId=355;
		Course course= new Course(355,"Node","this is Node js course");
		when(courseDao.getById(courseId)).thenReturn(course);
		assertThat(course).isEqualTo(courseServices.getCourse(courseId));
		
		
	}
}

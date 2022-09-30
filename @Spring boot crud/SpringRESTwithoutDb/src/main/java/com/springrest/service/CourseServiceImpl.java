package com.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;
	//added list of courses into the constructor. So each time when we call it, it will display this list
	public CourseServiceImpl() {
		
		list= new ArrayList();
		list.add(new Course(123, "Core java", "This is java core course!"));
		list.add(new Course(234, "Spring Boot", "This is Spring boot course!"));
		
	}
	
	@Override
	public List<Course> getCourses() {
	
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		
		Course c= null;
		for(Course course: list)
		{
			if(course.getId()==courseId)
			{
				c= course;
				break;
			}
		}
		
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		
		list.add(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		
		list.forEach(e -> {
			if(e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		list=this.list.stream().filter(e -> e.getId()!=parseLong).collect(Collectors.toList());
		
	}
	
	
	

}

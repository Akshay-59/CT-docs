package com.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.dao.CourseDao;
import com.springrest.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

	// Get all courses
	public List<Course> getCourses() {

		return courseDao.findAll();
	}

	// get one record by id
	public Course getCourse(long courseId) {

		return courseDao.getReferenceById(courseId);
	}

	
	public Course addCourse(Course course) {

		courseDao.save(course);
		return course;
	}

	public Course updateCourse(Course course) {

		courseDao.save(course); // there is no update method. instead u can use save, so if there is record
								// already it'll update or else save as the new record
		return course;
	}

	public void deleteCourse(long parseLong) {
		

		Course entity = courseDao.getReferenceById(parseLong);
		courseDao.delete(entity);
	}

}

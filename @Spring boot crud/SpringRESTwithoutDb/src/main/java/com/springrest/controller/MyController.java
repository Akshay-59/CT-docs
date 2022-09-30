package com.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.entity.Course;
import com.springrest.service.CourseService;

@RestController
public class MyController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to home page!";
		
	}
	
	//get the all courses
	@GetMapping("/courses")
	//or u can use alternative as @RequestMapping for getMapping
	//@RequestMapping(path= "/courses", method= RequestMethod.GET)
	public List<Course> getCourses(){
		
		return this.courseService.getCourses();
	}
	
	// get a single course details by id
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId)); // converts whatever the value u enter for courseId into long 
	}
	
	//adding the new course into the list
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return this.courseService.addCourse(course);
	}
	
	//update a course by using PUT request
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}
	
	
	
	//Delete a course by id
	//here passing Http status 
	@DeleteMapping("/courses/{courseId}")
		public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
			try {
				this.courseService.deleteCourse(Long.parseLong(courseId));
				return new ResponseEntity<> (HttpStatus.OK);
			}catch(Exception e) {
				return new ResponseEntity<> (HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	
	
}

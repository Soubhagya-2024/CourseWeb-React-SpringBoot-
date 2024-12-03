package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import  com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseServices;



@RestController
public class MyController {
	   @Autowired
	   private CourseServices courseservices;

	
        @GetMapping("/home")
		public String home()
		{
			return "this ia home page";
		}

		// get the Allcourses
		@GetMapping("/course")
		public List<Course> getCourses()
		{
			return this.courseservices.getCourses();
		}

        // get the courses
		@GetMapping("/course/{courseId}")
       public Course getCourse(@PathVariable String courseId) 
	   {
		return this.courseservices.getCourse(Long.parseLong(courseId));

	   }
	   //Adding the course
	   @PostMapping("/course")
	   public Course addCourse(@RequestBody Course course) {
		   return this.courseservices.addCourse(course);
	   }
	   // UPDATE the course
	   @PutMapping("/course")
	   public Course updateCourse(@RequestBody Course course) {
		   return this.courseservices.updateCourse(course);
	   }
	  
         
		

	}



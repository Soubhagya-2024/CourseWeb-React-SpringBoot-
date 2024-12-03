package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServicesimpl implements CourseServices {
    @Autowired
     private CourseDao courseDao;


    //For storing data temporary
    List<Course> list;
    public CourseServicesimpl()
    {
        list=new ArrayList<>();
        list.add(new Course(145,"java","tuotorial course only"));
    }
    
    //implements of getCourse to get all course
	@Override
	public List<Course> getCourses() {
		
		//return list;
        return courseDao.findAll();
	}
    //to implement getCourse()
    @Override
    
    public Course getCourse(long courseId) {
        /*  Course c = null;
        for (Course course : list) {
            if (course.getId() == courseId) {
                c = course;
                break;
            }
        }
        if (c == null) {
            System.out.println("Course not found for ID: " + courseId); // Debugging line
        }
        return c;*/
        return courseDao.findById(courseId).orElse(null); 
    }
    
    @Override
    public Course addCourse(Course course) {
        //list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        // Iterate through the list of courses
        /*for (Course e : list) {
            if (e.getId() == course.getId()) {
                // Update the course fields when the course ID matches
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
                break; // Exit the loop once the course is found and updated
            }
        }*/
        courseDao.save(course);
        return course;
    }
    
    
    }
   



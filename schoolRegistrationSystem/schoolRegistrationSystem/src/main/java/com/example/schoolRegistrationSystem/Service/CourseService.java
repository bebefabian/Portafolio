package com.example.schoolRegistrationSystem.Service;

import com.example.schoolRegistrationSystem.Model.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourses();
    Course createCourse(Course course);
    Course findCoursesById(long id);
    Course updateCourses(long id, Course course);
    long deleteCourse(long id);

}

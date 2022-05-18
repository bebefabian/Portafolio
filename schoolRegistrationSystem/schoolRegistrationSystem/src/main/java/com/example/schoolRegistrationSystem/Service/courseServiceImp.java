package com.example.schoolRegistrationSystem.Service;

import com.example.schoolRegistrationSystem.Model.Course;
import com.example.schoolRegistrationSystem.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class courseServiceImp implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course createCourse(Course course) {


        return courseRepository.save(course);
    }

    @Override
    public Course findCoursesById(long id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public Course updateCourses(long id, Course course) {
        Course editCourse = courseRepository.findById(id).get();

        editCourse.setCourseName(course.getCourseName());

        return courseRepository.save(editCourse);
    }

    @Override
    public long deleteCourse(long id) {
        Course eraseCourse = courseRepository.findById(id).get();
            courseRepository.delete(eraseCourse);

        return eraseCourse.getId();
    }
}

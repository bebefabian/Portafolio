package com.example.schoolRegistrationSystem.Controller;

import com.example.schoolRegistrationSystem.Model.Course;
import com.example.schoolRegistrationSystem.Repository.CourseRepository;
import com.example.schoolRegistrationSystem.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> allCourses(){
        return courseService.findAllCourses();
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }

    @GetMapping("{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable("id") long id){
        Course courseById = courseService.findCoursesById(id);
        return ResponseEntity.ok(courseById);
    }

    @PutMapping("{id}")
    public ResponseEntity<Course> editCourse(@PathVariable("id") long id, @RequestBody Course courseDetails){
        Course updatedCourse = courseService.updateCourses(id,courseDetails);
        return ResponseEntity.ok(updatedCourse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable("id") long id) {
        long delCourse = courseService.deleteCourse(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

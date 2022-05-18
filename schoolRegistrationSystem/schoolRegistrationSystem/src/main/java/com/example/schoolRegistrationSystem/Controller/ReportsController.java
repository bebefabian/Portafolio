package com.example.schoolRegistrationSystem.Controller;

import com.example.schoolRegistrationSystem.Model.Student;
import com.example.schoolRegistrationSystem.Model.Course;
import com.example.schoolRegistrationSystem.Repository.CourseRepository;
import com.example.schoolRegistrationSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1")
public class ReportsController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/reports/course/{id}/student")
    public ResponseEntity<List<Student>> getCourseStudent(@PathVariable("id") long id){
        Optional<Course> courseData = courseRepository.findById(id);

        if (courseData.isPresent()) {
            Course course = courseData.get();
                return new ResponseEntity<>(new ArrayList<Student>(course.getStudent()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reports/studentwithoutanycourse")
    public ResponseEntity<List<Student>> getStudentWithoutAnyCourse() {

        try {
            List<Student> students = studentRepository.findAll().stream().
                    filter(p -> p.getCourses().size() == 0).
                    collect(Collectors.toList());
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/reports/coursesWithoutAnyStudents")
    public ResponseEntity<List<Course>> getCourseWithoutAnyStudent() {
        try {
            List<Course> courses = courseRepository.findAll().stream().
                    filter(p -> p.getStudent().size() ==0).
                    collect(Collectors.toList());
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

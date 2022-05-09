package com.example.schoolRegistrationSystem.Controller;

import com.example.schoolRegistrationSystem.Model.Student;
import com.example.schoolRegistrationSystem.Repository.StudentRepository;
import com.example.schoolRegistrationSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> findAllStudent() { return studentService.findAllStudent(); }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable("id") long id) {
        Student studentById = studentService.findStudentById(id);
        return ResponseEntity.ok(studentById);
    }

    @PutMapping("{id}")
    public ResponseEntity<Student> editStudent(@PathVariable("id") long id, @RequestBody Student studentDetails){
        Student updatedStudent = studentService.updateStudent(id, studentDetails);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") long id) {
        long delStudent = studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

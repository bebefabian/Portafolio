package com.example.schoolRegistrationSystem.Service;

import com.example.schoolRegistrationSystem.Model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllStudent();
    Student createStudent(Student student);
    Student findStudentById(long id);
    Student updateStudent(long id, Student student);
    long deleteStudent(long id);

}

package com.example.schoolRegistrationSystem.Service;

import com.example.schoolRegistrationSystem.Model.Student;
import com.example.schoolRegistrationSystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        String fullName = getFullName(student);
        student.setFullName(fullName);
        return studentRepository.save(student);
    }

    @Override
    public Student findStudentById(long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(long id, Student student) {
        Student editStudent = studentRepository.findById(id).get();

        editStudent.setStudentName(student.getStudentName());
        editStudent.setStudentLastname(student.getStudentLastname());

        return studentRepository.save(editStudent);
    }

    @Override
    public long deleteStudent(long id) {
        Student eraseStudent = studentRepository.findById(id).get();
            studentRepository.delete(eraseStudent);

        return eraseStudent.getId();
    }

    public String getFullName(Student student){
        return student.getStudentName() + " " + student.getStudentLastname();
    }
}

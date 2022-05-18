package com.example.schoolRegistrationSystem.Repository;

import com.example.schoolRegistrationSystem.Model.Course;
import com.example.schoolRegistrationSystem.Model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {

    List<StudentCourse> findByCourseId(Long id);
}

package com.example.schoolRegistrationSystem.Repository;

import com.example.schoolRegistrationSystem.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

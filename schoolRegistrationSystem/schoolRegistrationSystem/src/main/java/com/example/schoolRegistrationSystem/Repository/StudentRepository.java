package com.example.schoolRegistrationSystem.Repository;

import com.example.schoolRegistrationSystem.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

package com.example.schoolRegistrationSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "student_name")
    public String studentName;

    @Column(name = "student_lastname")
    public String studentLastname;

    @Column(name = "full_name")
    public String fullName;
}

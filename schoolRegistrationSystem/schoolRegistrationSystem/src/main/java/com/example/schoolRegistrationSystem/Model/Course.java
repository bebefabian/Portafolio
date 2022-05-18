package com.example.schoolRegistrationSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "course_name")
    public String courseName;
//
//    @ManyToMany(mappedBy = "course", fetch = FetchType.EAGER)
//    @JsonIgnore
//    private Set<Student> student = new HashSet<>();

    public Course() {

    }

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

//    public Set<Student> getStudent() {
//        return student;
//    }
//
//    public void setStudent(Set<Student> student) {
//        this.student = student;
//    }
}


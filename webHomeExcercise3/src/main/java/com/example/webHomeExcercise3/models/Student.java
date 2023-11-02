package com.example.webHomeExcercise3.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name = "students")
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String name;
    @Column(unique = true)
    private String email;
    private int grade;
    @ManyToOne
    private Course course;

    public Student(String name, String email, int grade, Course course) {
        this.name = name;
        this.email = email;
        this.grade = grade;
        this.course = course;
    }

//    @JsonGetter("course")
//    public String getCourseData() {
//        return course != null ? course.getName() : "course not found";
//    }
}

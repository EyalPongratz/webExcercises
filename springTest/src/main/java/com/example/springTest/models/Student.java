package com.example.springTest.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String name;
    private Date birthday;
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Grade> grades;

    public Student(String name, Date birthday, boolean isActive, List<Grade> grades) {
        this.name = name;
        this.birthday = birthday;
        this.isActive = isActive;
        this.grades = grades;
    }
}

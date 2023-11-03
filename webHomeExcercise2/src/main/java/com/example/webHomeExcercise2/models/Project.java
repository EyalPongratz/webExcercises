package com.example.webHomeExcercise2.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Table(name = "projects")
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String title;
    private int totalHours;
    private int remainingHours;
    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    private List<Employee> employees;

    public Project(String title, int totalHours, List<Employee> employees) {
        this.title = title;
        this.totalHours = totalHours;
        this.remainingHours = totalHours;
        this.employees = employees;
    }
}

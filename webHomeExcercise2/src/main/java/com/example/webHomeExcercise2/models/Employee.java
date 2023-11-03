package com.example.webHomeExcercise2.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Table(name = "employees")
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String name;
    private String email;
    private double hourlyWage;
    private int monthlyHours;
    @ManyToOne
    private Project project;

    public Employee(String name, String email, double hourlyWage, Project project) {
        this.name = name;
        this.email = email;
        this.hourlyWage = hourlyWage;
        this.monthlyHours = 0;
        this.project = project;
    }
}

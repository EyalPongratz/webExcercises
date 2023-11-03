package com.example.webHomeVersion2.models;

import com.fasterxml.jackson.annotation.JsonGetter;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", hourlyWage=" + hourlyWage +
                ", monthlyHours=" + monthlyHours +
                ", project=" + project.getTitle() +
                '}';
    }

    @JsonGetter("project")
    public String getProjectShort() {
        return project.getTitle();
    }
}
package com.example.webHomeVersion2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Table(name = "projects")
public class Project {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto increment
    @Setter(AccessLevel.NONE)
    private int number;
    private String title;
    private int totalHours;
    private int remainingHours;
    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER)
    //@JsonIgnore
    //replaced by JsonGetter function
    private List<Employee> employees;

    public Project() {
        remainingHours = totalHours;
    }

    public Project(String title, int totalHours) {
        this.title = title;
        this.totalHours = totalHours;
        this.remainingHours = totalHours;
    }
}
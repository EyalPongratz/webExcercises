package com.example.webHomeExcercise4.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String title;
    private String body;
    private LocalDate dueDate;

    public Note(String title, String body, LocalDate dueDate) {
        this.title = title;
        this.body = body;
        this.dueDate = dueDate;
    }
}

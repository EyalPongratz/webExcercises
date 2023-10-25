package com.example.webHomeExcercise1.controllers;

import com.example.webHomeExcercise1.models.Note;
import com.example.webHomeExcercise1.services.NotesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notes")
public class NotesController {
    private NotesService service;

    public NotesController(NotesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Note> getNotes() {
        return service.getAllNotes();
    }

    @PostMapping
    public String addNote(@RequestBody Note note) {
        service.addNote(note);
        return "Note added successfully";
    }
}

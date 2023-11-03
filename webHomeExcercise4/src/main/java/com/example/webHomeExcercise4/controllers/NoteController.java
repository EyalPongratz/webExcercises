package com.example.webHomeExcercise4.controllers;

import com.example.webHomeExcercise4.Exceptions.AlreadyExistsException;
import com.example.webHomeExcercise4.Exceptions.DateExpiredException;
import com.example.webHomeExcercise4.Exceptions.NotExistException;
import com.example.webHomeExcercise4.models.Note;
import com.example.webHomeExcercise4.services.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("notes")
public class NoteController {
    private NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping("all")
    public List<Note> getAllNotes() {
        return service.getAllNotes();
    }

    @GetMapping("between")
    public List<Note> getNotesBetween(LocalDate start, LocalDate end) {
        return service.getAllNotesBetween(start, end);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) throws NotExistException {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    public ResponseEntity<String> addNote(@RequestBody Note note) throws AlreadyExistsException, DateExpiredException {
        service.addNote(note);
        return ResponseEntity.ok("Note added");
    }

    @PutMapping
    public ResponseEntity<String> updateNote(@RequestBody Note note) throws NotExistException, DateExpiredException {
        service.updateNote(note);
        return ResponseEntity.ok("Note updated");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteNote(@PathVariable int id) throws NotExistException {
        service.deleteNote(id);
        return ResponseEntity.ok("Note Deleted");
    }

    @DeleteMapping("byDate")
    public void deleteNotesByDate(LocalDate date) {
        service.deleteByDate(date);
    }
}

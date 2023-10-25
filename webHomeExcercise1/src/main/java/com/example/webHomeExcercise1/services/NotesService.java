package com.example.webHomeExcercise1.services;

import com.example.webHomeExcercise1.models.Note;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotesService {
    private List<Note> notes = new ArrayList<>();
    public List<Note> getAllNotes() {
        return notes;
    }
    public List<Note> getNotesByCategory(String category) {
        return notes.stream().filter(note-> note.getCategory().equals(category)).toList();
    }
    public void addNote(Note note) {
        notes.add(note);
    }

}

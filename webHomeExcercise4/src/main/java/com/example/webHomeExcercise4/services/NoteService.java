package com.example.webHomeExcercise4.services;

import com.example.webHomeExcercise4.Exceptions.AlreadyExistsException;
import com.example.webHomeExcercise4.Exceptions.DateExpiredException;
import com.example.webHomeExcercise4.Exceptions.NotExistException;
import com.example.webHomeExcercise4.models.Note;
import com.example.webHomeExcercise4.repositories.NoteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class NoteService {
    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note getById(int id) throws NotExistException {
        return noteRepository.findById(id).orElseThrow(()-> new NotExistException("No note exists with id: " + id));
    }

    public List<Note> getAllNotesBetween(LocalDate start, LocalDate end) {
        return noteRepository.findAllByDueDateBetween(start, end);
    }

    public void addNote(Note note) throws DateExpiredException, AlreadyExistsException {
        LocalDate currentDate = LocalDate.now();

        if (note.getDueDate().isBefore(currentDate))
            throw new DateExpiredException("The date: " + note.getDueDate() + " has expired");
        else if(noteRepository.existsById(note.getId()))
            throw new AlreadyExistsException("A note with id " + note.getId() + " already exists");
        else
            noteRepository.save(note);
    }

    public void updateNote(Note note) throws DateExpiredException, NotExistException {
        LocalDate currentDate = LocalDate.now();

        if (note.getDueDate().isBefore(currentDate))
            throw new DateExpiredException("The date: " + note.getDueDate() + " has expired");
        else if (!noteRepository.existsById(note.getId()))
            throw new NotExistException("No Note exists under id: " + note.getId());
        else
            noteRepository.save(note);
    }

    public void deleteNote(int id) throws NotExistException {
        if (!noteRepository.existsById(id))
            throw new NotExistException("No Note exists under id: " + id);
        else
            noteRepository.deleteById(id);
    }

    public void deleteByDate(LocalDate date) {
        noteRepository.deleteByDueDate(date);
    }
}

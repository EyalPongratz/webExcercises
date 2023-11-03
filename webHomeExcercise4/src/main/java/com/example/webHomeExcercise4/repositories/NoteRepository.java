package com.example.webHomeExcercise4.repositories;

import com.example.webHomeExcercise4.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
    public List<Note> findAllByDueDateBetween(LocalDate start, LocalDate end);
    public void deleteByDueDate(LocalDate date);
}

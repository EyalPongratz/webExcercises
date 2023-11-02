package com.example.webHomeExcercise3.repositories;

import com.example.webHomeExcercise3.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    public boolean existsByEmail(String email);

    public Optional<Student> findByEmail(String email);
}

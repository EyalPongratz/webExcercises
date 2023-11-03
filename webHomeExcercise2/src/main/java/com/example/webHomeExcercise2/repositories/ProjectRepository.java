package com.example.webHomeExcercise2.repositories;

import com.example.webHomeExcercise2.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
    public boolean existsByTitle(String title);
}

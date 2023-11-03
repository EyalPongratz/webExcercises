package com.example.webHomeExcercise2.Services;

import com.example.webHomeExcercise2.models.Project;
import com.example.webHomeExcercise2.repositories.EmployeeRepository;
import com.example.webHomeExcercise2.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;

    public EmployeeService(EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    public Project getOneProject(int id) {
        return projectRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No project exists under id:" + id));
    }
}

package com.example.webHomeExcercise2.repositories;

import com.example.webHomeExcercise2.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public boolean existsById(int id);
    public boolean existsByEmail(String email);
}

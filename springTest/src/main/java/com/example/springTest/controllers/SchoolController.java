package com.example.springTest.controllers;

import com.example.springTest.exception.SchoolSystemException;
import com.example.springTest.models.Student;
import com.example.springTest.services.SchoolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class SchoolController {
    private SchoolService service;

    public SchoolController(SchoolService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student) throws SchoolSystemException {
        service.addStudent(student);
        return ResponseEntity.ok("Student added");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(long id) throws SchoolSystemException {
        service.deleteStudent(id);
        return ResponseEntity.ok("Student deleted");
    }

    @GetMapping("all")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping
    public ResponseEntity<?> getStudentById(long id) throws SchoolSystemException {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    @GetMapping("average")
    public ResponseEntity<?> getGradeAverage(long id) throws SchoolSystemException {
        return ResponseEntity.ok(service.getGradeAverage(id));
    }
}

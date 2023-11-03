package com.example.webHomeVersion2.controllers;

import com.example.webHomeVersion2.Exceptions.NotFoundException;
import com.example.webHomeVersion2.models.Project;
import com.example.webHomeVersion2.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getProject(int id) {
        try {
            return ResponseEntity.ok(service.getOneProject(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<String> updateWorkHours(int id, int hours) {
        try {
            service.workHours(id, hours);
            return ResponseEntity.ok("Hours were added");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}

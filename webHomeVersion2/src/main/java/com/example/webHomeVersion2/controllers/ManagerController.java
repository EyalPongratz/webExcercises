package com.example.webHomeVersion2.controllers;

import com.example.webHomeVersion2.models.Employee;
import com.example.webHomeVersion2.models.Project;
import com.example.webHomeVersion2.repositories.EmployeeRepository;
import com.example.webHomeVersion2.services.ManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("manager")
public class ManagerController {
    private ManagerService service;

    public ManagerController(ManagerService service) {
        this.service = service;
    }

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("projects")
    public List<Project> getAllProjects() {
        return service.getAllProjects();
    }

    @PostMapping("employee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        service.addEmployee(employee);
        return ResponseEntity.ok("Employee added");
    }

    @PostMapping("projects")
    public ResponseEntity<String> addEmployee(@RequestBody Project project) {
        service.addProject(project);
        return ResponseEntity.ok("Project added");
    }

    @PutMapping("employee")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
        if(service.updateEmployee(employee))
            return ResponseEntity.ok("Employee updated");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating employee");
    }


}

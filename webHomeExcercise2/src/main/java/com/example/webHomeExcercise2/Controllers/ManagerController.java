package com.example.webHomeExcercise2.Controllers;

import com.example.webHomeExcercise2.Exceptions.AlreadyExistsException;
import com.example.webHomeExcercise2.Services.ManagerService;
import com.example.webHomeExcercise2.models.Employee;
import com.example.webHomeExcercise2.models.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("manager")
public class ManagerController {
    private ManagerService managerService;
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @PostMapping("addProject")
    public ResponseEntity<?> addProject(@RequestBody Project project) {
        try {
            managerService.addProject(project);
            return ResponseEntity.status(HttpStatus.CREATED).body("Project added");
        } catch (AlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("addEmployee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        try {
            managerService.addEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body("Employee added");
        } catch (AlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("updateEmployee")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        try {
            managerService.updateEmployee(employee);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Employee updated");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("getOneEmployee")
    public ResponseEntity<?> getEmployeeById(int id) {
        try {
            return ResponseEntity.ok(managerService.getOneEmployee(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("getAllEmployees")
    public List<Employee> getAllEmployees() {
        return managerService.getAllEmployees();
    }

    @DeleteMapping("deleteEmployee")
    public ResponseEntity<?> deleteEmployee(int id) {
        try {
            managerService.deleteEmployee(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Employee deleted");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee id not found");
        }
    }
}

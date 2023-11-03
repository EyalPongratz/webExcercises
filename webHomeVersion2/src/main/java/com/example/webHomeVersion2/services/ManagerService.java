package com.example.webHomeVersion2.services;

import com.example.webHomeVersion2.Exceptions.NotFoundException;
import com.example.webHomeVersion2.models.Employee;
import com.example.webHomeVersion2.models.Project;
import com.example.webHomeVersion2.repositories.EmployeeRepository;
import com.example.webHomeVersion2.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;

    public ManagerService(EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void addProject(Project project) {
        projectRepository.save(project);
    }

    public boolean updateEmployee(Employee employee) {
        if(employeeRepository.existsById(employee.getId())) {
            employeeRepository.save(employee);
            return true;
        }
        return false;
    }

    public boolean updateProject(Project project) {
        if(projectRepository.existsById(project.getNumber())) {
            projectRepository.save(project);
            return true;
        }
        return false;
    }

    public boolean deleteEmployee(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean deleteProject(int number) {
        if (projectRepository.existsById(number)) {
            projectRepository.deleteById(number);
            return true;
        }
        return false;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Employee getOneEmployee(int id) throws NotFoundException {
        return employeeRepository.findById(id).orElseThrow(()-> new NotFoundException("Employee id not found"));
    }

    public Project getOneProject(int number) throws NotFoundException {
        return projectRepository.findById(number).orElseThrow(()-> new NotFoundException("Project number not found"));
    }

    public double showEmployeeTotalWage(int id) throws NotFoundException {
        Employee employee = getOneEmployee(id);
        return employee.getHourlyWage() * employee.getMonthlyHours();
    }
}

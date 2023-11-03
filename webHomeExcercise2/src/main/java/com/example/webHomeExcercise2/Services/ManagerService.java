package com.example.webHomeExcercise2.Services;

import com.example.webHomeExcercise2.Exceptions.AlreadyExistsException;
import com.example.webHomeExcercise2.models.Employee;
import com.example.webHomeExcercise2.models.Project;
import com.example.webHomeExcercise2.repositories.EmployeeRepository;
import com.example.webHomeExcercise2.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ManagerService {
    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;
    public ManagerService(EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    public void addEmployee(Employee employee) throws AlreadyExistsException {
        if(employeeRepository.existsByEmail(employee.getEmail()))
            throw new AlreadyExistsException("An employee already exists with email: " + employee.getEmail());
        else
            employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) throws NoSuchElementException {
        if(employeeRepository.existsById(employee.getId()))
            employeeRepository.save(employee);
        else
            throw new NoSuchElementException("No employee exists under id: " + employee.getId());
    }

    public void deleteEmployee(int id) throws NoSuchElementException {
        if(employeeRepository.existsById(id))
            employeeRepository.deleteById(id);
        else
            throw new NoSuchElementException("No employee exists under id: " + id);
    }

    public Employee getOneEmployee(int id) throws NoSuchElementException {
        return employeeRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No employee exists under id: " + id));
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void addProject(Project project) throws AlreadyExistsException {
        if(projectRepository.existsByTitle(project.getTitle()))
            throw new AlreadyExistsException("A project already exists with title:" + project.getTitle());
        else
            projectRepository.save(project);
    }

    public void updateProject(Project project) throws NoSuchElementException {
        if(projectRepository.existsById(project.getId()))
            projectRepository.save(project);
        else
            throw new NoSuchElementException("No project exists under id:" + project.getId());
    }

    public void deleteProject(int id) throws NoSuchElementException {
        if(projectRepository.existsById(id))
            projectRepository.deleteById(id);
        else
            throw new NoSuchElementException("No project exists under id:" + id);
    }

    public Project getOneProject(int id) throws NoSuchElementException {
        return projectRepository.findById(id).orElseThrow(()-> new NoSuchElementException("No project exists under id:" + id));
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public double showEmployeeTotalWage(int id) throws NoSuchElementException {
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new NoSuchElementException("No employee exists under id: " + id));
        return employee.getHourlyWage() * employee.getMonthlyHours();
    }
}

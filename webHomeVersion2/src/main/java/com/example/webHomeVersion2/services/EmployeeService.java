package com.example.webHomeVersion2.services;

import com.example.webHomeVersion2.Exceptions.NotFoundException;
import com.example.webHomeVersion2.models.Employee;
import com.example.webHomeVersion2.models.Project;
import com.example.webHomeVersion2.repositories.EmployeeRepository;
import com.example.webHomeVersion2.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    public Project getOneProject(int id) throws NotFoundException {
        return employeeRepository.findById(id).orElseThrow(NotFoundException::new).getProject();
    }

    public void workHours(int id, int hours) throws NotFoundException {
        Employee employee = employeeRepository.findById(id).orElseThrow(NotFoundException::new);
        Project project = employee.getProject();
        employee.setMonthlyHours(employee.getMonthlyHours() + hours);
        project.setRemainingHours(project.getRemainingHours() - hours);
        employeeRepository.save(employee);
    }
}

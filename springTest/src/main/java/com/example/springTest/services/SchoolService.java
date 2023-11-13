package com.example.springTest.services;

import com.example.springTest.exception.SchoolSystemException;
import com.example.springTest.models.Grade;
import com.example.springTest.models.Student;
import com.example.springTest.repositories.GradeRepository;
import com.example.springTest.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {
    private StudentRepository studentRepository;
    private GradeRepository gradeRepository;

    public SchoolService(StudentRepository studentRepository, GradeRepository gradeRepository) {
        this.studentRepository = studentRepository;
        this.gradeRepository = gradeRepository;
    }

    public void addStudent(Student student) throws SchoolSystemException {
        if (student.getId() != 0)
            throw new SchoolSystemException("student id must not be set for add operation");
        studentRepository.save(student);
    }

    public void deleteStudent(long id) throws SchoolSystemException {
        if (!studentRepository.existsById(id))
            throw new SchoolSystemException("id not found");
        else studentRepository.deleteById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(long id) throws SchoolSystemException {
        return studentRepository.findById(id).orElseThrow(()-> new SchoolSystemException("id not found"));
    }

    public double getGradeAverage(long id) throws SchoolSystemException {
        Student student = studentRepository.findById(id).orElseThrow(()-> new SchoolSystemException("id not found"));
        double average = 0.0;
        for (Grade grade: student.getGrades()) {
            average += grade.getGrade();
        }
        return average/student.getGrades().size();
    }
}

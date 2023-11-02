package com.example.webHomeExcercise3.services;

import com.example.webHomeExcercise3.Exceptions.AlreadyExistsException;
import com.example.webHomeExcercise3.Exceptions.NotExistException;
import com.example.webHomeExcercise3.models.Course;
import com.example.webHomeExcercise3.models.Student;
import com.example.webHomeExcercise3.repositories.CourseRepository;
import com.example.webHomeExcercise3.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeFacade {
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public CollegeFacade(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public void addCourse(Course course) throws AlreadyExistsException {
        if (courseRepository.existsById(course.getId()))
            throw new AlreadyExistsException("A course with id: " + course.getId() + " already exists");
        else
            courseRepository.save(course);
    }

    public void addStudent(Student student) throws AlreadyExistsException {
        if (studentRepository.existsById(student.getId()))
            throw new AlreadyExistsException("A student with id: " + student.getId() + " already exists");
        else if (studentRepository.existsByEmail(student.getEmail()))
            throw new AlreadyExistsException("A student with email: " + student.getEmail() + " already exists");
        else
            studentRepository.save(student);
    }

    public void deleteCourse(int id) throws NotExistException {
        if (!courseRepository.existsById(id))
            throw new NotExistException("No course exists under id: " + id);
        else
            courseRepository.deleteById(id);
    }

    public void deleteStudent(int id) throws NotExistException {
        if (!studentRepository.existsById(id))
            throw new NotExistException("No student exists under id: " + id);
        else
            studentRepository.deleteById(id);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Course getCourseById(int id) throws NotExistException {
        return courseRepository.findById(id).orElseThrow(()-> new NotExistException("No course exists under id: " + id));
    }

    public Student getStudentById(int id) throws NotExistException {
        return studentRepository.findById(id).orElseThrow(()-> new NotExistException("No student exists under id: " + id));
    }

    public Student getStudentByEmail(String email) throws NotExistException {
        return studentRepository.findByEmail(email).orElseThrow(()->new NotExistException("No student exists with email: " + email));
    }

    public List<Course> getCourseByMaxPrice(float maxPrice) {
        return courseRepository.findByPriceLessThanEqual(maxPrice);
    }

    public List<Course> getCoursesBetweenDurations(int min, int max) {
        return courseRepository.findByDurationBetween(min, max);
    }
}

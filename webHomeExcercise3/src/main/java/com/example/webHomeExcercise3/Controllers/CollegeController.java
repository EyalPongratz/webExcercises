package com.example.webHomeExcercise3.Controllers;

import com.example.webHomeExcercise3.Exceptions.AlreadyExistsException;
import com.example.webHomeExcercise3.Exceptions.NotExistException;
import com.example.webHomeExcercise3.models.Course;
import com.example.webHomeExcercise3.models.Student;
import com.example.webHomeExcercise3.services.CollegeFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("college")
public class CollegeController {
    private CollegeFacade facade;

    public CollegeController(CollegeFacade facade) {
        this.facade = facade;
    }

    @PostMapping("course")
    public ResponseEntity<String> addCourse(@RequestBody Course course) throws AlreadyExistsException {
        facade.addCourse(course);
        return ResponseEntity.ok("Course added");
    }

    @PostMapping("student")
    public ResponseEntity<String> addStudent(@RequestBody Student student) throws AlreadyExistsException {
        facade.addStudent(student);
        return ResponseEntity.ok("Student added");
    }

    @DeleteMapping("course/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable int id) throws NotExistException {
        facade.deleteCourse(id);
        return ResponseEntity.ok("Course deleted");
    }

    @DeleteMapping("student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) throws NotExistException {
        facade.deleteStudent(id);
        return ResponseEntity.ok("Student deleted");
    }

    @GetMapping("courses")
    public List<Course> getAllCourses() {
        return facade.getAllCourses();
    }

    @GetMapping("students")
    public List<Student> getAllStudents() {
        return facade.getAllStudents();
    }

    @GetMapping("courseById/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) throws NotExistException {
        return ResponseEntity.ok(facade.getCourseById(id));
    }

    @GetMapping("studentById/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) throws NotExistException {
        return ResponseEntity.ok(facade.getStudentById(id));
    }

    @GetMapping("studentByEmail/{email}")
    public ResponseEntity<?> getStudentByEmail(@PathVariable String email) throws NotExistException {
        return ResponseEntity.ok(facade.getStudentByEmail(email));
    }

    @GetMapping("price/{price}")
    public List<Course> getCoursesByMaxPrice(@PathVariable float price) {
        return facade.getCourseByMaxPrice(price);
    }

    @GetMapping("duration")
    public List<Course> getCoursesBetweenDurations(int min, int max) {
        return facade.getCoursesBetweenDurations(min, max);
    }

//    @ExceptionHandler(NotExistException.class)
//    public ResponseEntity<?> handleNotExistException(HttpServletRequest req, Exception e) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//    }
}

package com.crud.student_management_system.controller;

import com.crud.student_management_system.entity.Student;
import com.crud.student_management_system.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
// created service layer
//    private final StudentRepository repository;
//
//    public StudentController(StudentRepository repository) {
//        this.repository = repository;
//    }
private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
       // return repository.save(student);
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
//        return repository.findAll();
        return studentService.getAllStudents();
    }

    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        return studentService.updateStudent(id, student);
    }

//    @GetMapping("/{id}")
//    public Student getStudent(@PathVariable Long id) {
//        return repository.findById(id).orElse(null);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteStudent(@PathVariable Long id) {
//        repository.deleteById(id);
//        return "Student Deleted";
//    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "Student Deleted";
    }
}

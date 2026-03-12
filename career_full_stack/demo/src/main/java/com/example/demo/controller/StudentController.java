package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.services.StudentService;

@RestController
@CrossOrigin("*") // Allow all origins for easier frontend testing
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudents")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/student/{uid}")
    public Optional<Student> getStudentByID(@PathVariable Long uid) {
        return studentService.getStudentByID(uid);
    }

    @DeleteMapping("/delete/{uid}")
    public void deleteStudentByID(@PathVariable Long uid) {
        studentService.deleteStudentByID(uid);
    }

    @PutMapping("/update/{uid}")
    public Student updateStudentByID(@PathVariable Long uid, @RequestBody Student student) {
        return studentService.updateStudentByID(uid, student);
    }

    @PostMapping("/create")
    public Student createStudentAPI(@RequestBody Student student) {

        return studentService.createStudent(student);

    }

    @PostMapping("/login")
    public Student login(@RequestBody Student student) {
        System.out.println("Login Request Received: " + student); // Debug logging
        return studentService.login(student.getName(), student.getEmail());
    }

}

package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.respository.StudentRepo;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentByID(Long uid) {
        return studentRepo.findById(uid);
    }

    public void deleteStudentByID(Long uid) {

        // if (studentRepo.existsById(uid)) {
        // studentRepo.deleteById(uid);
        // } else {
        // System.out.println("Student not found");
        // }

        studentRepo.findById(uid).orElseThrow(() -> new RuntimeException("Student Not Found"));

        studentRepo.deleteById(uid);

    }

    public Student updateStudentByID(Long uid, Student student) {
        Student existingStudent = studentRepo.findById(uid).orElse(null);
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setCourse(student.getCourse());
            existingStudent.setEmail(student.getEmail());
            existingStudent.setSection(student.getSection());
            return studentRepo.save(existingStudent);
        }
        return null;
    }

    public Student login(String name, String email) {
        Student student = studentRepo.findByEmail(email);
        if (student != null && student.getName().equals(name)) {
            return student;
        }
        return null;
    }

}

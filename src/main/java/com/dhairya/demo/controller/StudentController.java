package com.dhairya.demo.controller;

import com.dhairya.demo.model.Student;
import com.dhairya.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable(value = "id") Integer studentid){
        return studentService.getStudent(studentid);
    }
    @PostMapping("/students")
    public void saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }
    @DeleteMapping("students/{id}")
    public void deleteStudent(@PathVariable(value = "id") Integer studentid){
        studentService.deleteStudent(studentid);
    }
}

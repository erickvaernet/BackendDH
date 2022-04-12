package com.example.jpaHibernate.controller;

import com.example.jpaHibernate.models.Student;
import com.example.jpaHibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/students")
public class StudentController {
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(produces = "application/json")
    public List<Student> getStudents(){
        return studentService.findAllStudents();
    }

    @GetMapping(value ="/{id}" ,produces = "application/json")
    public Student getStudent(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping(produces = "application/json")
    public Student addStudent(@RequestBody Student st){
        return studentService.addStudent(st);
    }

    @DeleteMapping(value ="/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

}

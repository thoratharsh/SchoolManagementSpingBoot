package com.schoolmanagement.schoolmanagement.controller;

import com.schoolmanagement.schoolmanagement.dao.Student;
import com.schoolmanagement.schoolmanagement.repository.SchoolRepository;
import com.schoolmanagement.schoolmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentRepository.findById(id).get();
    }

    @PostMapping()
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @DeleteMapping()
    public String deleteStudent(@PathVariable Integer id){
        studentRepository.deleteById(id);
        return "Done";
    }
}

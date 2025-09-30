package com.schoolmanagement.schoolmanagement.controller;

import com.schoolmanagement.schoolmanagement.dao.Student;
import com.schoolmanagement.schoolmanagement.repository.SchoolRepository;
import com.schoolmanagement.schoolmanagement.repository.StudentRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/all")
    @Operation(summary = "Get All Students")
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Student by id")
    public Student getStudent(@PathVariable Integer id){
        return studentRepository.findById(id).get();
    }

    @PostMapping()
    @Operation(summary = "Create Students")
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @DeleteMapping()
    @Operation(summary = "Delete Student")
    public String deleteStudent(@PathVariable Integer id){
        studentRepository.deleteById(id);
        return "Done";
    }
}

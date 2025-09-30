package com.schoolmanagement.schoolmanagement.controller;

import com.schoolmanagement.schoolmanagement.dao.Faculty;
import com.schoolmanagement.schoolmanagement.dao.Student;
import com.schoolmanagement.schoolmanagement.repository.FacultyRepository;
import com.schoolmanagement.schoolmanagement.repository.StudentRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyRepository facultyRepository;

    @GetMapping("/all")
    @Operation(summary = "Get All Faculty")
    public List<Faculty> getAllFaculty(){
        return facultyRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Faculty by id")
    public Faculty getFaculty(@PathVariable Integer id){
        return facultyRepository.findById(id).get();
    }

    @PostMapping()
    @Operation(summary = "Create Faculty")
    public Faculty createFaculty(@RequestBody Faculty faculty){
        return facultyRepository.save(faculty);
    }

    @DeleteMapping()
    @Operation(summary = "Delet Faculty")
    public String deleteFaculty(@PathVariable Integer id){
        facultyRepository.deleteById(id);
        return "Done";
    }
}

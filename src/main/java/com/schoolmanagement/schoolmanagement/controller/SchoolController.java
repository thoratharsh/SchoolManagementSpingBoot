package com.schoolmanagement.schoolmanagement.controller;

import com.schoolmanagement.schoolmanagement.dao.School;
import com.schoolmanagement.schoolmanagement.repository.SchoolRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @GetMapping("/all")
    @Operation(summary = "Get All Schools")
    public List<School> getAllSchools(){
        return schoolRepository.findAll();
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create School")
    public School createSchool(@RequestBody School school){
        schoolRepository.save(school);
        return school;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Delete School")
    public String deleteSchool(@PathVariable Integer id){
        Optional<School> school = schoolRepository.findById(id);
        if (school.isPresent()){
            schoolRepository.deleteById(id);
        }
        return "Done";
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get School")
    public School getSchool(@PathVariable Integer id){
       Optional<School> school =  schoolRepository.findById(id);
       return school.orElseGet(() -> (School) Collections.emptyList());
    }

}

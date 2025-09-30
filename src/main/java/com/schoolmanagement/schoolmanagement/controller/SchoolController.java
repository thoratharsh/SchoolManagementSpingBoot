package com.schoolmanagement.schoolmanagement.controller;

import com.schoolmanagement.schoolmanagement.dao.School;
import com.schoolmanagement.schoolmanagement.repository.SchoolRepository;
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
    public List<School> getAllSchools(){
        return schoolRepository.findAll();
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public School createSchool(@RequestBody School school){
        schoolRepository.save(school);
        return school;
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteSchool(@PathVariable Integer id){
        Optional<School> school = schoolRepository.findById(id);
        if (school.isPresent()){
            schoolRepository.deleteById(id);
        }
        return "Done";
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public School getSchool(@PathVariable Integer id){
       Optional<School> school =  schoolRepository.findById(id);
       return school.orElseGet(() -> (School) Collections.emptyList());
    }

}

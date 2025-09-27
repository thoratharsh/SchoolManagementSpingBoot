package com.schoolmanagement.schoolmanagement.controller;

import com.schoolmanagement.schoolmanagement.dao.School;
import com.schoolmanagement.schoolmanagement.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/school/")
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @GetMapping("/allSchools")
    public List<School> getAllSchools(){
        return schoolRepository.getAllSchools();
    }


    @PostMapping("/school")
    @ResponseStatus(HttpStatus.CREATED)
    public School createSchool(@RequestBody School school){
        schoolRepository.addSchool(school);
        return school;
    }


    @DeleteMapping("/school/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteSchool(@PathVariable Integer id){
        Optional<School> school = schoolRepository.getSchool(id);
        school.ifPresent(value -> schoolRepository.removeSchool(value));
        return "Deleted";
    }

    @GetMapping("/school/{id}")
    @ResponseStatus(HttpStatus.OK)
    public School getSchool(@PathVariable Integer id){
       Optional<School> school =  schoolRepository.getSchool(id);
        return school.orElseGet(() -> new School(-1, "Not found", "not found"));
    }

}

package com.schoolmanagement.schoolmanagement.controller;

import com.schoolmanagement.schoolmanagement.dao.SchoolDao;
import com.schoolmanagement.schoolmanagement.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/school/")
public class SchoolController {

    @Autowired
    private SchoolRepository schoolRepository;

    @GetMapping("/allSchools")
    public List<SchoolDao> getAllSchools(){
        return schoolRepository.findAll();
    }


    @PostMapping("/school")
    @ResponseStatus(HttpStatus.CREATED)
    public SchoolDao createSchool(@RequestBody SchoolDao school){
        schoolRepository.save(school);
        return school;
    }


    @DeleteMapping("/school/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteSchool(@PathVariable Integer id){
        Optional<SchoolDao> school = schoolRepository.findById(id);
        if (school.isPresent()){
            schoolRepository.deleteById(id);
        }
        return "Done";
    }

    @GetMapping("/school/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SchoolDao getSchool(@PathVariable Integer id){
       Optional<SchoolDao> school =  schoolRepository.findById(id);
       return school.orElseGet(() -> (SchoolDao) Collections.emptyList());
    }

}

package com.schoolmanagement.schoolmanagement.repository;


import com.schoolmanagement.schoolmanagement.dao.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
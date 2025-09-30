package com.schoolmanagement.schoolmanagement.repository;

import com.schoolmanagement.schoolmanagement.dao.Faculty;
import com.schoolmanagement.schoolmanagement.dao.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
}
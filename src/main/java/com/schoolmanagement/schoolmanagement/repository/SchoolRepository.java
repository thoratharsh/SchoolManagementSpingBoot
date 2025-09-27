package com.schoolmanagement.schoolmanagement.repository;


import com.schoolmanagement.schoolmanagement.dao.SchoolDao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<SchoolDao, Integer> {
}
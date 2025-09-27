package com.schoolmanagement.schoolmanagement.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "SCHOOL")
public class SchoolDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String name;

    public String address;

}

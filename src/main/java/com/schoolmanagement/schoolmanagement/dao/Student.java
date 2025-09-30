package com.schoolmanagement.schoolmanagement.dao;

import jakarta.persistence.*;

@Entity(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String name;

    public String class_name;

    @JoinColumn(name = "school_id", nullable = false)
    public Integer school;

}

package com.schoolmanagement.schoolmanagement.dao;

import jakarta.persistence.*;

@Entity(name = "FACULTY")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String name;

    public String role;

    @JoinColumn(name = "school_id", nullable = false)
    public Integer school;
}

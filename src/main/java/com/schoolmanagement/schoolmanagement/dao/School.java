package com.schoolmanagement.schoolmanagement.dao;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity(name = "SCHOOL")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String name;

    public String address;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Student> students;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<Faculty> faculty;

}

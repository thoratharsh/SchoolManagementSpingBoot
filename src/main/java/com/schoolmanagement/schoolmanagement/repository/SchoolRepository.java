package com.schoolmanagement.schoolmanagement.repository;

import com.schoolmanagement.schoolmanagement.dao.School;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Getter
@Component
public class SchoolRepository {

    private List<School> allSchools = new LinkedList<>(List.of(
            new School(1, "as", "as"),
            new School(2, "asas", "asas")
    ));

    public void addSchool(School school){
        allSchools.add(school);
    }


    public void removeSchool(School school){
        allSchools.remove(school);
    }


    public Optional<School> getSchool(int id){
        return allSchools
                .stream()
                .filter( e-> e.getId() == id)
                .findFirst();
    }

}

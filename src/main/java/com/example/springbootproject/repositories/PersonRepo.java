package com.example.springbootproject.repositories;

import com.example.springbootproject.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PersonRepo extends JpaRepository<Person, Long> {
    List<Person> findByName(String name);

    List<Person> findByAgeBetween(int minAge, int maxAge);
}

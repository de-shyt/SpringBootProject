package com.example.springbootproject.services;

import com.example.springbootproject.entities.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MockPersonRepository {
    private int nextId = 0;
    private final Map<Integer, Person> database;

    public MockPersonRepository() {
        this.database = new HashMap<>();
    }

    public Map<Integer, Person> getDatabase() {
        return database;
    }

    public Person add(String name, String gender, int age) {
        int id = nextId++;
        Person person = new Person(id, name, gender, age);
        database.put(id, person);
        return person;
    }

    public Person getById(Integer id) {
        return database.get(id);
    }

    public List<Person> getByName(String name) {
        List<Person> result = new ArrayList<>();
        for (var person : database.values())
            if (person.getName().equals(name)) result.add(person);
        return result;
    }

    public Person remove(Integer id) {
        return database.remove(id);
    }
}

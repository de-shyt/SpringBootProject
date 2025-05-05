package com.example.springbootproject.repositories;

import com.example.springbootproject.entities.Person;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MockPersonRepository {
    private Long nextId = 0L;
    @Getter
    private final Map<Long, Person> database;

    public MockPersonRepository() {
        this.database = new HashMap<>();
    }

    public Person add(String name, String gender, int age) {
        Long id = nextId++;
        Person person = new Person(id, name, gender, age);
        database.put(id, person);
        return person;
    }

    public Person getById(Long id) {
        return database.get(id);
    }

    public List<Person> getByName(String name) {
        List<Person> result = new ArrayList<>();
        for (Person person : database.values())
            if (person.getName().equals(name)) result.add(person);
        return result;
    }

    public Person remove(Long id) {
        return database.remove(id);
    }
}

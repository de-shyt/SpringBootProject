package com.example.springbootproject.entities.json;

import com.example.springbootproject.entities.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "gender", "age"})
public class PersonWithoutAnimalJson {
    @JsonProperty("name")
    private String name;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("age")
    private int age;

    public PersonWithoutAnimalJson() {}

    public PersonWithoutAnimalJson(Person person) {
        this.name = person.getName();
        this.gender = person.getGender();
        this.age = person.getAge();
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
}

package com.example.springbootproject.dto;

import com.example.springbootproject.entities.Person;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name", "gender", "age", "animal"})
public class PersonDTO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("age")
    private int age;

    public PersonDTO() {}

    public PersonDTO(Person person) {
        this.id = person.getId();
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

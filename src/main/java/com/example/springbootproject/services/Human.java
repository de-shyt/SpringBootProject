package com.example.springbootproject.services;

import com.example.springbootproject.animals.Animal;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Human {
    @JsonProperty("name")
    private String name;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("age")
    private int age;
    protected Animal animal;

    public Human(String name, String gender, int age, Animal animal) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.animal = animal;
    }
}

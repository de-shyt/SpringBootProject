package com.example.springbootproject.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Human {
    @JsonProperty("name")
    private String name;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("age")
    private int age;
    protected Animal animal;

    public Human(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}

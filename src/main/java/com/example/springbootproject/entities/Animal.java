package com.example.springbootproject.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Animal {
    @JsonProperty("species")
    private final String species;
    @JsonProperty("name")
    private String name;
    @JsonProperty("age")
    private int age;
    @JsonProperty("owner")
    private Human owner;

    public Animal(String species, String name, int age) {
        this.species = species;
        this.name = name;
        this.age = age;
    }

    public void setOwner(Human owner) {
        this.owner = owner;
    }
}
